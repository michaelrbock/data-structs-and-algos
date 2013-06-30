public interface List<E> extends java.lang.Iterable<E> {
	
	public void append(E e);

	public boolean insertAt(int index, E e);

	public void clear();

	public boolean contains(E e);

	public E get(int index);

	/** Return index of first matching element.
	 *  Return -1 if no match. 
	 */
	public int indexOf(E e);

	public boolean isEmpty();
	
	/** Return index of the last matching element.
	 * Return -1 if no match. 
	 */
	public int lastIndexOf(E e);
	
	/** Remove the first occurrence of element.
	 * Shift other elements left.
	 * Return true if element is removed. 
	 */
	public boolean remove(E e);
	
	/** Remove element at given index.
	 * Shift other elements left.
	 * Return removed element.
	 */
	public E remove(int index);
	
	/** Replace element at index with specified element and
	 * return old element.
	 */
	public E set(int index, E e);
	
	public int size();
}
