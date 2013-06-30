public class TestLinkedList {
	/** Main method */
	public static void main(String[] args) {
		// Create a list of Strings
		LinkedList<String> list = new LinkedList<String>();

		// Add to list and print
		list.append("America");
		list.print(); // [America]

		// Add to beginning
		list.prepend("Canada");
		list.print(); // [Canada, America]

		list.append("Russia");
		list.print(); // [Canada, America, Russia]

		list.append("France");
		list.print(); // [Canada, America, Russia, France]

		// Insert at location
		list.insertAt(2, "Germany");
		list.print(); // [Canada, America, Germany, Russia, France]

		list.insertAt(5, "Norway");
		list.print(); // [Canada, America, Germany, Russia, France, Norway]

		// Same as prepend
		list.insertAt(0, "Japan");
		list.print(); // [Japan, Canada, America, Germany, Russia, France, Norway]

		list.remove(0);
		list.print(); // [Canada, America, Germany, Russia, France, Norway]

		list.remove(2);
		list.print(); // [Canada, America, Russia, France, Norway]

		// Remove the last element and test .size()
		list.remove(list.size() - 1);
		list.print(); // [Canada, America, Russia, France]
	}
}