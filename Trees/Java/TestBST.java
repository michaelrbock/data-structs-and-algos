import java.util.*;

public class TestBST {
	public static void main(String[] args) {
		// Create a BST
		BST<String> tree = new BST<String>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		
		// Traverse the tree
		System.out.print("(1) Inorder (sorted): ");
		tree.inorder();
		System.out.print("\n(2) Postorder: ");
		tree.postorder();
		System.out.print("\n(3) Preorder: ");
		tree.preorder();
		System.out.print("\n(4) The number of nodes is " + tree.getSize());
		
		// Search
		System.out.println("\n(5) Is Peter in the tree: " + tree.search("Peter"));
		
		// Get a path from the root to Peter
		System.out.print("(6) A path from the root to Peter is: ");
		ArrayList<BST.TreeNode<String>> path = tree.path("Peter");
		for (int i = 0; path != null && i < path.size(); i++)
			System.out.print(path.get(i).element + " ");
		
		Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
		BST<Integer> intTree = new BST<Integer>(numbers);
		System.out.print("\n\n(7) Inorder (sorted): ");
		intTree.inorder();
	}
}
