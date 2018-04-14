import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class RBTreeMapTest {

    @Test
    public void testGet() {
	RBTreeMap<Integer, String> test = new RBTreeMap<Integer, String>();
	test.put(0, "A");
	test.put(1, "B");
	test.put(2, "C");
	test.put(3, "D");
	test.put(4, "E");
	assertEquals("Get value at key: ", "B", test.get(1));
	assertEquals("Get value at key: ", "E", test.get(4));
	assertTrue("Confirm properties: ", test.verify());
    }

    @Test
    public void testPut() {
	RBTreeMap<Integer, String> test = new RBTreeMap<Integer, String>();
	test.put(0, "A");
	test.put(1, "B");
	test.put(2, "C");
	test.put(3, "D");
	test.put(4, "E");
	Iterator<Map.Entry<Integer, String>> it = test.entries();
	while (it.hasNext()) {
	    System.out.print(it.next() + " ");
	}
	System.out.println();
	assertTrue("Confirm properties: ", test.verify());

    }

    @Test
    public void testDoubleRotations() {
	RBTreeMap<Integer, String> test = new RBTreeMap<Integer, String>();
	test.put(25, "A");
	test.put(5, "F");
	test.put(10, "B");
	// LR; rotate left then right
	test.put(9, "C");
	// recolors
	test.put(6, "D");
	// RL; rotate right then left
	test.put(4, "E");
	Iterator<Map.Entry<Integer, String>> it = test.entries();
	while (it.hasNext()) {
	    System.out.print(it.next() + " ");
	}
	System.out.println();
	assertTrue("Confirm properties: ", test.verify());
    }

    @Test
    public void testSingleRotation() {
	RBTreeMap<Integer, String> test = new RBTreeMap<Integer, String>();
	test.put(25, "A");
	test.put(5, "F");
	test.put(4, "B");
	// rotate right
	test.put(60, "C");
	test.put(70, "Y");
	// rotate left
	assertTrue("Confirm properties: ", test.verify());
    }

    @Test
    public void testExistingValue() {
	RBTreeMap<Integer, String> test = new RBTreeMap<Integer, String>();
	test.put(0, "A");
	test.put(1, "B");
	test.put(2, "C");
	test.put(3, "D");
	test.put(4, "E");
	test.put(3, "R");
	assertEquals("Get value at key: ", "R", test.get(3));
	assertTrue("Confirm properties: ", test.verify());
    }

}
