import java.util.*;
import java.io.*;

public class WebPageIndex {
   private RBTreeMap<String, List<Integer>> map;
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
			   posList.add(wordCount);
			   map.put(currentWord, posList);
			   // Otherwise, add the new value to the existing list.
		   } else {
			   currentValues.add(wordCount);
		   }
		   
		   wordCount++;
	   }
   }     
   
   // Returns a count of the words in this web page
   public int getWordCount() {
      // TODO - implement me! - add some comments too!
      return -1;
   }
   
   public String getUrl() {
      // TODO - implement me! - add some comments too!
      return "";
   }
   
   public boolean contains(String s) {
      // TODO - implement me! - add some comments too!
      return false;
   }
   
   public int getCount(String s) {
      // TODO - implement me! - add some comments too!
      return -1;
   }
   
   public double getFrequency(String s) {
      // TODO - implement me! - add some comments too!
      return -1.0;
   }
   
   public List<Integer> getLocations(String s) {
      // TODO - implement me! - add some comments too!
      return null;
   }

   // return an Iterator over all the words in the index
   public Iterator<String> words() {
      // TODO - implement me! - add some comments too!
      return null;
   }
   
   public String toString() {
      // TODO - implement me! - add some comments too!
      return "";
   }

   // The main method is an application using a WebPageIndex
   public static void main(String[] args) throws IOException {
      // TODO - implement me! - add some comments too!
   }

   
   /* 
    * additional features to support multi-word phrases 
    * work on these after you have the previous methods working correctly
    */
   
   public boolean containsPhrase(String s) {
      // TODO - implement me! - add some comments too!
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
