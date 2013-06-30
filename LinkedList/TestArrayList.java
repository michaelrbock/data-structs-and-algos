
public class TestArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		
		// Test normal functionality:
		
		list.append("America");
		System.out.println("(1) " + list); // (1) [America]
		
		list.insertAt(0, "Canada");
		System.out.println("(2) " + list); // (2) [Canada, America]
		
		list.append("Russia");
		System.out.println("(3) " + list); // (3) [Canada, America, Russia]
		
		list.append("France");
		System.out.println("(4) " + list); // (4) [Canada, America, Russia, France]
		
		list.insertAt(2, "Germany");
		System.out.println("(5) " + list); // (5) [Canada, America, Germany, Russia, France]
		
		list.insertAt(5, "Norway");
		System.out.println("(6) " + list); // (6) [Canada, America, Germany, Russia, France, Norway]
		
		list.remove("Canada");
		System.out.println("(7) " + list); // (7) [America, Germany, Russia, France, Norway]
		
		list.remove(2);
		System.out.println("(8) " + list); // (8) [America, Germany, France, Norway]
		
		list.remove(list.size() - 1);
		System.out.println("(9) " + list); // (9) [America, Germany, France]
		
		// Test iterator:
		for (String s: list)
			System.out.print(s.toUpperCase() + " "); // AMERICA GERMANY FRANCE
	}
}
