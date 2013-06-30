
public abstract class AbstractList<E> implements List<E> {
	protected int size = 0;
	
	/** No arg constructor */
	protected AbstractList() { }
	
	/** Create list from array */
	protected AbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			append(objects[i]);
	}
	
	/** Add new element at the end of the list */
	@Override
	public void append(E e) {
		insertAt(size, e);
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else
			return false;
	}
}
