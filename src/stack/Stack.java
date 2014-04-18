package stack;

public class Stack {

	public static void main(String[] args) {
		LinkedStackOfStrings stack = new LinkedStackOfStrings();

		long startList = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			stack.push(Integer.toString(i));
		}

		for (int i = 0; i < 100000; i++) {
			stack.pop();
		}

		long endList = System.nanoTime();
		System.out.println(endList - startList);

		FiexedCapacityStackOfStrings array = new FiexedCapacityStackOfStrings(
				1000000);
		long startArray = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			array.push(Integer.toString(i));
		}

		for (int i = 0; i < 100000; i++) {
			array.pop();
		}

		long endArray = System.nanoTime();
		System.out.println(endArray - startArray);

	}

}

class LinkedStackOfStrings {

	private Node first = null;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}

	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
}

class FiexedCapacityStackOfStrings {
	private final String[] s;
	private int N = 0;

	public FiexedCapacityStackOfStrings(int capacity) {
		s = new String[capacity];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(String item) {
		s[N++] = item;
	}

	public String pop() {
		return s[--N];
	}
}
