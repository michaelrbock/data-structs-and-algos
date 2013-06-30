
public class GenericStack<E> {
	private ArrayList<E> list = new ArrayList<E>();
	
	public void push(E e) {
		list.append(e);
	}
	
	public E pop() {
		return list.remove(list.size()-1);
	}
	
	public int getSize() {
		return list.size();
	}
	
	@Override
	public String toString() {
		return "Stack: " + list.toString();
	}
}
