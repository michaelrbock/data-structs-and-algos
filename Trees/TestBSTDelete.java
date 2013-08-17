
public class TestBSTDelete {
	public static void main(String[] args) {
		BST<String> tree = new BST<String>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		printTree(tree);
		
		System.out.println("\nDelete George");
		tree.delete("George");
		printTree(tree);
		
		System.out.println("\nDelete Adam");
		tree.delete("Adam");
		printTree(tree);
		
		System.out.println("\nDelete Michael");
		tree.delete("Michael");
		printTree(tree);
	}

	public static void printTree(BST t) {
		//Traverse tree
		System.out.print("(1) Inorder (sorted): ");
		t.inorder();
		System.out.print("\n(2) Postorder: ");
		t.postorder();
		System.out.print("\n(3) Preorder: ");
		t.preorder();
		System.out.print("\n(4) The number of nodes is " + t.getSize());
		System.out.println();
	}
}
