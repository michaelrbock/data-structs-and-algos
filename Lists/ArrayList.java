
public class ArrayList<E> extends AbstractList<E> {
	public static final int INITIAL_CAPACITY = 16;
	private E[] data = (E[])new Object[INITIAL_CAPACITY];
	
	/** Create default list */
	public ArrayList() { }
	
	public ArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			append(objects[i]);
	}
	
	@Override
	public boolean insertAt(int index, E e) {
		if(index < 0)
			return false;
		
		ensureCapacity();
		
		// Move the elements to the right after the specified index
		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];
		
		// Insert new element
		data[index] = e;
		
		size++;
		return true;
	}
	
	public void ensureCapacity() {
		if (size >= data.length) {
			E[] newData = (E[])(new Object[size * 2 + 1]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}
	
	@Override
	public void clear() {
		data = (E[])new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	@Override
	public boolean contains(E e) {
		for (int i = 0; i < size; i++)
			if (e.equals(data[i]))
				return true;
		
		return false;
	}
	
	@Override
	public E get(int index) {
		checkIndex(index);
		
		return data[index];
	}
	
	public void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index " + index + " out of bounds");
		}
	}
	
	@Override
	public int indexOf(E e) {
		for (int i = 0; i < size; i++)
			if (e.equals(data[i]))
				return i;
		
		return -1;
	}
	
	@Override
	public int lastIndexOf(E e) {
		for (int i = size - 1; i >= 0; i--)
			if (e.equals(data[i]))
				return i;
		
		return -1;
	}
	
	@Override
	public E remove(int index) {
		checkIndex(index);
		
		E e = data[index];
		
		// Shift data to the left
		for (int i = index; i < size - 1; i++)
			data[i] = data[i + 1];
		
		data[size - 1] = null;
		size--;
		
		return e;
	}
	
	@Override
	public E set(int index, E e) {
		checkIndex(index);
		E old = data[index];
		data[index] = e;
		return old;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		
		for (int i = 0; i < size; i++) {
			result.append(data[i]);
			if (i < size - 1)
				result.append(", ");
		}
		
		return result.toString() + "]";
	}
	
	public void trimToSize() {
		if (size != data.length) {
			E[] newData = (E[])(new Object[size]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}
	
	@Override
	public java.util.Iterator<E> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements java.util.Iterator<E> {
		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return (current < size);
		}
		
		@Override
		public E next() {
			return data[current++];
		}
		
		@Override
		public void remove() {
			ArrayList.this.remove(current);
		}
	}
}
