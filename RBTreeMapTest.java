import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	assertTrue("Confirm properties: ", test.verify());

    }

    @Test
    public void testLL() {
	// single right rotation
	RBTreeMap<Integer, String> test = new RBTreeMap<Integer, String>();
	test.put(25, "A");
	test.put(5, "F");
	test.put(10, "B");
	test.put(9, "C");
	test.put(6, "D");
	test.put(4, "E");
	Iterator<Map.Entry<Integer, String>> it = test.entries();
	while (it.hasNext()) {
	    System.out.print(it.next() + " ");
	}
	assertTrue("Confirm properties: ", test.verify());
    }

    @Test
    public void testRL() {
	// single left rotation then
    }

    @Test
    public void testRBTreeMapKVRBTreeMapOfKVRBTreeMapOfKV() {
	fail("Not yet implemented");
    }

    @Test
    public void testRBTreeMapKV() {
	fail("Not yet implemented");
    }

}
