
public interface Tree<E extends Comparable<E>> extends Iterable<E> {
	/** @return true if the element is in the tree */
	public boolean search(E e);
	
	/** Insert element e into the binary search tree. 
	 *  @return true if the element is inserted successfully */
	public boolean insert(E e);
	
	/** Delete the specified element from the tree
	 *  @return true if the element is deleted successfully */
	public boolean delete(E e);
	
	/** Inorder traversal from the root */
	public void inorder();
	
	/** Postorder traversal from the root */
	public void postorder();
	
	/** Preorder traversal from the root */
	public void preorder();
	
	/** Get the number of nodes in the tree */
	public int getSize();
	
	/** Return true if the tree is empty */
	public boolean isEmpty();
	
	/** Return an iterator to traverse the elements in the tree */
	public java.util.Iterator<E> iterator();

}
