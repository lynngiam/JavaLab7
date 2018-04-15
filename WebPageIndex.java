import java.util.*;
import java.io.*;

public class WebPageIndex {
   private RBTreeMap<String, List<Integer>> map = new RBTreeMap<String, List<Integer>>();
   private String baseUrl;
   private int wordCount;
   //TODO: Insert the instance variables here

   // WebPageIndex constructor
   WebPageIndex(String url) throws IOException{
	   baseUrl = url;
	   wordCount = 1;
	   HTMLScanner input = new HTMLScanner(baseUrl);
	   
	   while (input.hasNext()) {
		   
		   String currentWord = input.next();
		   
		   // Finds the current values associated with the current word.
		   List<Integer> currentValues = map.get(currentWord);
		   // If there are no current values, make a new list and put in the first one.
		   if (currentValues == null) {
			   List<Integer> posList = new LinkedList<Integer>();
			   posList.add(wordCount-1);
			   currentWord = currentWord.toLowerCase();
			   map.put(currentWord, posList);
			   // Otherwise, add the new value to the existing list.
		   } else {
			   currentValues.add(wordCount-1);
		   }
		   
		   wordCount++;
	   }
	   System.out.println();
   }     
   
   // Returns a count of the words in this web page
   public int getWordCount() {
	   //Simply returns the field wordCount.
      return wordCount;
   }
   
   public String getUrl() {
      // Simply returns the field baseUrl.
      return baseUrl;
   }
   
   public boolean contains(String s) {
	   // Returns true if the word is found in the map.
	   if (map.get(s) != null) return true;
	   return false;
   }
   
   public int getCount(String s) {
	   List<Integer> wordList = map.get(s);
	   if (wordList != null) {
		   return wordList.size();
	   }
	   return 0;
   }
   
   public double getFrequency(String s) {	   
	   int count = getCount(s);
	   return ((double) count) / wordCount;
   }
   
   public List<Integer> getLocations(String s) {
	   // Return the list stored in the map if the word is found, 
	   // Else return empty list.
      List<Integer> wordList = map.get(s);		  
      
      if (wordList != null) return wordList;
      return new LinkedList<Integer>();
   }

   // return an Iterator over all the words in the index
   public Iterator<String> words() {
      return map.keys();
   }
   
   public String toString() {
      return map.toString();
   }

   // The main method is an application using a WebPageIndex
   public static void main(String[] args) throws IOException {
	   WebPageIndex input = new WebPageIndex(args[0]);
	   Iterator<String> words = input.words();
	   while (words.hasNext()) {
		   String word = words.next();
		   System.out.printf("%-20s", word);
		   System.out.printf("%-10.5f", (input.getFrequency(word)));
		   System.out.printf("%-10s\n", input.getLocations(word));
	   }
   }

   
   /* 
    * additional features to support multi-word phrases 
    * work on these after you have the previous methods working correctly
    */
   
   public boolean containsPhrase(String s) {
	   // Create scanner to break down words in s and put them into an arraylist. 
      Scanner phrase = new Scanner(s);
      List<String> wordsInPhrase = new ArrayList<String>();
      
      while (phrase.hasNext()) {
    	  String word = phrase.next();
    	  wordsInPhrase.add(word);
      }
      
      // Check that all words in the phrase s are in the web page.
      for (String word : wordsInPhrase) {
    	  if (!contains(word)) {
    		  return false;
    	  }
      }
      
      // Create arraylist indices which contains the positions where each word, in phrase s,
      //occurs in the web page.
      List<List<Integer>> indices = new ArrayList<List<Integer>>();      
      
      for (String word : wordsInPhrase) {
    	  List<Integer> positions = map.get(word);
    	  indices.add(positions);
      }
      
      // Go through each positions of the first word in s and trace a path through 
      //next words. Return true if their positions increment by 1. Otherwise, false.
      boolean contains = false;
      List<Integer> firstWordPositions = indices.get(0); 
      for (Integer pos : firstWordPositions) {
    	  if (containsPhraseHelper(pos, indices, 1)) {
    		  contains = true;
    		  break;
    	  }
      }
      return contains;
   }
   
   // Private recursive method called by containsPhrase(). If the next word's position is 1 greater than the current,
   //recurse and do it again for the next and the word after next. Stop when the word index exceeds size.
   private boolean containsPhraseHelper(Integer pos, List<List<Integer>> indices, Integer nextListIndex) {
	   if (indices.size() <= nextListIndex) return true;
	   
	   List<Integer> nextList = indices.get(nextListIndex);
	   for (Integer nextPos : nextList) {
		   if (nextPos - pos == 1) {
			   return containsPhraseHelper(nextPos, indices, nextListIndex + 1);
		   }
	   }
	   
	   return false;
   }
   
   public int getPhraseCount(String s) {
      // TODO - implement me! - add some comments too!
      return -1;
   }
   
   public double getPhraseFrequency(String s) {
      // TODO - implement me! - add some comments too!
      return -1.0;
   }

   public List<Integer> getPhraseLocations(String s) {
      // TODO - implement me! - add some comments too!
      return null;
   }
   
   
}