package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.head = new LLNode(null);
		this.tail = new LLNode(null);
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element The element to add
	 */
	public boolean add(E element) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}

		LLNode<E> node = new LLNode(element);

		if (this.head.next == null && this.tail.prev == null) {
			this.head.next = node;
			node.prev = this.head;
			this.tail.prev = node;
			node.next = this.tail;
			this.size++;
		} else {
			this.tail.prev.next = node;
			node.prev = this.tail.prev;
			node.next = this.tail;
			this.tail.prev = node;
			this.size++;
		}

		return false;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */

	public E get(int index) {
		indexValidation(index);

		LLNode<E> storedNode = null;

		storedNode = this.head;
		for (int i = 0; i <= index; i++) {
			storedNode = storedNode.next;
		}

		return storedNode.data;
	}

	private LLNode<E> getNode(int index) {
		indexValidation(index);

		LLNode<E> storedNode = null;

		storedNode = this.head;
		for (int i = 0; i <= index; i++) {
			storedNode = storedNode.next;
		}

		return storedNode;
	}

	private void indexValidation(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}

		if(this.size == 0) {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The     index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) {
		// TODO: Implement this method
		indexValidation(index);

		this.size++;

		LLNode<E> current = getNode(index);
		LLNode<E> previous = current.prev;
		LLNode<E> newNode = new LLNode(element);

		current.prev = newNode;
		newNode.next = current;
		newNode.prev = previous;
		previous.next = newNode;
		
	}

	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return this.size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method
		indexValidation(index);
		LLNode<E> current = getNode(index);
		LLNode<E> previous = current.prev;
		LLNode<E> next = current.next;
		previous.next = next;
		next.prev = previous;
		this.size--;
		return current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index   The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		indexValidation(index);
		LLNode<E> current = getNode(index);
		E previousData = current.data;
		current.data = element;
		return previousData;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
