
public class GenericQueue<E> {
	// Create a queue with an underlying LinkedList
	// and only the appropriate methods opened up by the API.
	private LinkedList<E> list = new LinkedList<E>();
	
	public void enqueue(E e) {
		list.append(e);
	}
	
	public E dequeue() {
		return list.removeFirst();
	}
	
	public int getSize() {
		return list.size();
	}
	
	@Override
	public String toString() {
		return "Queue: " + list.toString();
	}
}
