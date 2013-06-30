public class TestLinkedList {
	/** Main method */
	public static void main(String[] args) {
		// Create a list of Strings
		LinkedList<String> list = new LinkedList<String>();

		// Test overall functionality:
		
		list.append("America");
		list.print(); // [America]

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
		
		
		// Test each method normal functionality:
		
		System.out.println(list.getFirst()); // Canada
		
		System.out.println(list.getLast()); // France
		
		list.prepend("Mexico");
		list.print(); // [Mexico, Canada, America, Russia, France]
		
		list.append("Italy");
		list.print(); // [Mexico, Canada, America, Russia, France, Italy]
		
		list.insertAt(3, "India");
		list.print(); // [Mexico, Canada, America, India, Russia, France, Italy]
		
		list.removeFirst();
		list.print(); // [Canada, America, India, Russia, France, Italy]
		
		list.removeLast();
		list.print(); // [Canada, America, India, Russia, France]
		
		list.remove(3);
		list.print(); // [Canada, America, India, France]
		
		list.remove("France");
		list.print(); // [Canada, America, India]
		
		System.out.println(list.contains("America")); // true
		
		System.out.println(list.contains("Hello")); // false
		
		System.out.println(list.get(2)); // India
		
		System.out.println(list.indexOf("America")); // 1
		
		list.append("America");
		list.print(); // [Canada, America, India, America]
		System.out.println(list.lastIndexOf("America")); // 3
		
		list.set(3, "Italy");
		list.print(); // [Canada, America, India, Italy]

		list.clear();
		list.print(); // []
		
		
		// Test corner cases:
		
		System.out.println(list.getFirst()); // null
		
		System.out.println(list.getLast()); // null
		
		list.prepend("America");
		list.print(); // [America]
		
		list.clear();
		list.append("Canada");
		list.print(); // [Canada]
		
		System.out.println(list.insertAt(-1, "")); // false
		
		list.insertAt(100, "Russia");
		list.print(); // [Canada, Russia]
		
		list.clear();
		System.out.println(list.removeFirst()); // null
		
		System.out.println(list.removeLast()); // null
		
		System.out.println(list.remove(-1)); // null
		
		System.out.println(list.remove(100)); // null
		
		System.out.println(list.get(-1)); // null
		
		System.out.println(list.indexOf("Hello")); // -1
		
		System.out.println(list.lastIndexOf("Hello")); // -1		
		
		System.out.println(list.set(-1, "")); // null
		
		list.print(); // []
		
		
		// Test iterator
		list.append("America");
		list.append("Canada");
		list.append("Russia");
		list.append("Germany");
		for (String s: list)
			System.out.print(s.toUpperCase() + " ");
	}
}