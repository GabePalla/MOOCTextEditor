/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10;

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> LList;
	MyLinkedList<Integer> LList2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

		LList = new MyLinkedList<Integer>();
		LList.add(1);
		LList.add(2);
		LList.add(3);
		LList.add(4);

		LList.set(1, 10);
		LList.set(2, 11);
		LList.set(3, 12);

		LList2 = new MyLinkedList<Integer>();
		LList2.add(1);
		LList2.add(2);
		LList2.add(3);
		LList2.add(4);
		LList2.add(2, 20);
		LList2.add(2, 30);
		LList2.add(2, 40);

	}

	/**
	 * Test if the get method is working correctly.
	 */
	/*
	 * You should not need to add much to this method.
	 * We provide it as an example of a thorough test.
	 */
	@Test
	public void testGet() {
		// test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

	}

	/**
	 * Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.
	 */
	@Test
	public void testRemove() {
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		// TODO: Add more tests here
	}

	/**
	 * Test adding an element into the end of the list, specifically
	 * public boolean add(E element)
	 */
	@Test
	public void testAddEnd() {
		// TODO: implement this test

	}

	/** Test the size of the list */
	@Test
	public void testSize() {
		// TODO: implement this test
		assertEquals("Check the size of the shortList: ", 2, shortList.size());
		assertEquals("Check the size of the emptyList: ", 0, emptyList.size());
		assertEquals("Check the size of the longerList: ", LONG_LIST_LENGTH, longerList.size());
		assertEquals("Check the size of the LList4: ", 4, LList.size());
		assertEquals("Check the size of the LList2: ", 7, LList2.size());

	}

	/**
	 * Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 */
	@Test
	public void testAddAtIndex() {
		// TODO: implement this test
		assertEquals("Should be a 40: ", (Integer)40, LList2.get(2));
		assertEquals("Should be a 30: ", (Integer)30, LList2.get(3));
		assertEquals("Should be a 20: ", (Integer)20, LList2.get(4));
		assertEquals("Should be a 2: ", (Integer)3, LList2.get(5));
		

	}

	/** Test setting an element in the list */
	@Test
	public void testSet() {
		// TODO: implement this test
		assertEquals("Should be a 10: ", (Integer)10, LList.get(1));
		assertEquals("Should be a 11: ", (Integer)11, LList.get(2));
		assertEquals("Should be a 12: ", (Integer)12, LList.get(3));
	}

	// TODO: Optionally add more test methods.

}
