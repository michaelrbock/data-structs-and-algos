
public class LinkedList<E> extends AbstractList<E> {
	
	// Definition of the Node class
	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E e) {
			element = e;
		}
	}

	// Linked List Data
	private Node<E> head;
	private Node<E> tail;
	
	/** Create default list */
	public LinkedList() {}
	
	/** Create list from array of objects */
	public LinkedList(E[] objects) {
		super(objects);
	}
	
	public E getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return head.element;
		}
	}
	
	public E getLast() {
		if (size == 0) {
			return null;
		}
		else {
			return tail.element;
		}
	}
	
	/** Add element to beginning of list */
	public void prepend(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		head = newNode;
		size++;
		
		if (tail == null)
			tail = newNode;
	}
	
	/** Add element to end of list */
	public void append(E e) {
		Node<E> newNode = new Node<E>(e);
		
		if (tail == null) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = tail.next;
		}
		
		size++;
	}
	
	@Override
	public boolean insertAt(int index, E e) {
		if (index < 0) {
			return false;
		}
		else if (head == null || index == 0) {
			prepend(e);
			return true;
		}
		else if (index >= size - 1) {
			append(e);
			return true;
		}
		
		Node<E> current = head;
		for (int i = 1; i < index; i++)
			current = current.next;
		Node<E> temp = current.next;
		current.next = new Node<E>(e);
		(current.next).next = temp;
		size++;
		return true;
	}
	
	public E removeFirst() {
		if (head == null) { // aka size == 0
			return null;
		}
		
		Node<E> temp = head;
		head = head.next;
		size--;
		if (head == null) {
			tail = null;
		}
		return temp.element;
	}
	
	public E removeLast() {
		if (tail == null) {
			return null;
		}
		else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		
		Node<E> current = head;
		for (int i = 0; i < size - 2; i++) {
			current = current.next;
		}
		
		Node<E> temp = tail;
		tail = current;
		tail.next = null;
		size--;
		return temp.element;
	}
	
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		else if (index == 0) {
			return removeFirst();
		}
		else if (index == size - 1) {
			return removeLast();
		}
		
		Node<E> current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		
		Node<E> temp = current.next;
		current.next = temp.next;
		size--;
		return temp.element;
	}
	
	@Override
	public void clear() {
		size = 0;
		head = tail = null;
	}
	
	@Override
	public boolean contains(E e) {
		Node<E> current = head;
		while (current != null) {
			if (current.element.equals(e)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		else if (head == tail) {
			return head.element;
		}
		
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			if (current != null)
				current = current.next;
			else
				return null;
		}
		
		return current.element;
	}
	
	@Override
	public int indexOf(E e) {
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e)) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}
	
	@Override
	public int lastIndexOf(E e) {
		Node<E> current = head;
		int result = -1;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e)) {
				result = i;
			}
			current = current.next;
		}
		return result;
	}
	
	@Override
	public E set(int index, E e) {
		if (index < 0 || index >= size) {
			return null;
		}
		
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		E temp = current.element;
		current.element = e;
		return temp;
	}
	
	public void print() {
		System.out.print("[");
		
		if (size == 0) {
			System.out.print("]\n");
			return;
		}
		
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			System.out.print(current.element);
			current = current.next;
			if (current != null) {
				System.out.print(", ");
			}
			else {
				System.out.print("]\n");
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			if (i != size - 1)
				result.append(", ");
			current = current.next;
		}
		
		result.append("]");
		return result.toString();
	}

	@Override
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = head;
		
		@Override
		public boolean hasNext() {
			return (current != null);
		}
		
		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			
		}
	}
}