import java.util.*;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
	protected TreeNode<E> root;
	protected int size = 0;

	/** Create an empty binary search tree */
	public BST() { }

	/** Create a binary search tree from an array of objects */
	public BST(E[] objects) {
		for (E object: objects)
			insert(object);
	}

	@Override /** Return true if element is in the tree */
	public boolean search(E e) {
		TreeNode<E> current = root; // Start from root

		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
				current = current.right;
			}
			else // e matches current.element
				return true;
		}

		return false; // no match
	}

	@Override /** Insert element e into binary search tree
	 * @return true if element is inserted successfully */
	public boolean insert(E e) {
		if (root == null)
			root = createNewNode(e); // Create a new root
		else {
			// Locate parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}
				else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}
				else // e == current.element
					return false; // Node already exists, not inserted
			}

			// Create the new node and attach it to parent
			if (e.compareTo(parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}
		size++;
		return true;
	}

	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<E>(e);
	}

	@Override /** Inorder traversal from the root */
	public void inorder() {
		inorder(root);
	}

	/** Inorder traversal from a source node */
	protected void inorder(TreeNode<E> source) {
		if (source == null) return;
		inorder(source.left);
		System.out.print(source.element + " ");
		inorder(source.right);
	}

	@Override /** Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	/** Postorder traversal from a source node */
	protected void postorder(TreeNode<E> source) {
		if (source == null) return;
		postorder(source.left);
		postorder(source.right);
		System.out.print(source.element + " ");
	}

	@Override /** Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	/** Preorder traversal from a source node */
	protected void preorder(TreeNode<E> source) {
		if (source == null) return;
		System.out.print(source.element + " ");
		preorder(source.left);
		preorder(source.right);
	}

	/** This inner class is static, b/c it does not access
	 *  any instance members defined in the outer class */
	public static class TreeNode<E> {
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}
	
	@Override /** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}
	
	/** Returns the root node of the tree */
	public TreeNode<E> getRoot() {
		return root;
	}
	
	/** Returns a path from the root leading to the specified element */
	public ArrayList<TreeNode<E>> path(E e) {
		ArrayList<TreeNode<E>> list = new ArrayList<TreeNode<E>>();
		TreeNode<E> current = root; // Start from the root
		
		while (current != null) {
			list.add(current); // Add node to path list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
				current = current.right;
			}
			else // Found the element
				break;
		}
		
		return list;
	}
	
	@Override /** Delete an element from the binary search tree
	 * @return true if element is successfully deleted
	 * @return false if element is not in tree */
	public boolean delete(E e) {
		//Locate node to be deleted and its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			}
			else // e == current.element
				break; // current is pointing at e
		}
		
		if (current == null)
			return false; // Element is not in the tree
		
		// Case 1: current has no left children
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			}
			else {
				if (e.compareTo(parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}
		else {
			// Case 2: the current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and its parent
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			
			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // keep going to the right
			}
			
			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;
			
			// Eliminate right-most node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}
		
		size--;
		return true;
	}

	@Override /** Obtain an iterator using inorder */
	public Iterator<E> iterator() {
		return new InorderIterator();
	}
	
	// Inner class InorderIterator
	private class InorderIterator implements Iterator<E> {
		//Store the elements in a list
		private ArrayList<E> list = new ArrayList<E>();
		private int current = 0; // Point to the current element in the list
		
		public InorderIterator() {
			inorder(); // Traverse binary tree and store elements
		}
		
		/** Inorder traversal from the root */
		private void inorder() {
			inorder(root);
		}
		
		/** Inorder traversal from a source node */
		private void inorder(TreeNode<E> source) {
			if (source == null) return;
			inorder(source.left);
			list.add(source.element);
			inorder(source.right);
		}
		
		@Override /** @return if more elements for traversing */
		public boolean hasNext() {
			if (current < list.size()) 
				return true;
			// else
			return false;
		}
		
		@Override /** Get the current element and move to the next */
		public E next() {
			return list.get(current++);
		}
		
		@Override /** Remove the current element */
		public void remove() {
			delete(list.get(current)); // Delete the current element
			list.clear(); // Clear the list
			inorder(); // rebuild the list
		}
	}
	
	/** Remove all elements from the tree */
	public void clear() {
		root = null;
		size = 0;
	}
}
