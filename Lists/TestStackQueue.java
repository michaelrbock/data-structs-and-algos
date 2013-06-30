
public class TestStackQueue {
	public static void main(String[] args) {
		//Test stack functionality:
		GenericStack<String> stack = new GenericStack<String>();
		
		stack.push("Tom");
		System.out.println("(1) " + stack); // (1) Stack: [Tom]
		
		stack.push("Susan");
		System.out.println("(2) " + stack); // (2) Stack: [Tom, Susan]
		
		stack.push("Kim");
		stack.push("Michael");
		System.out.println("(3) " + stack); // (3) Stack: [Tom, Susan, Kim, Michael]
		
		System.out.println("(4) " + stack.pop()); // (4) Michael
		System.out.println("(5) " + stack.pop()); // (5) Kim
		System.out.println("(6) " + stack); // (6) Stack: [Tom, Susan]
		System.out.println("");
		
		
		//Test queue functionality:
		GenericQueue<String> queue = new GenericQueue<String>();
		
		queue.enqueue("One");
		System.out.println("(1) " + queue); // (1) Queue: [One]
		
		queue.enqueue("Two");
		System.out.println("(2) " + queue); // (2) Queue: [One, Two]
		
		queue.enqueue("Three");
		queue.enqueue("Four");
		System.out.println("(3) " + queue); // (3) Queue: [One, Two, Three, Four]
		
		System.out.println("(4) " + queue.dequeue()); // (4) One
		System.out.println("(5) " + queue.dequeue()); // (5) Two
		System.out.println("(6) " + queue); // (6) Queue: [Three, Four]
	}
}
