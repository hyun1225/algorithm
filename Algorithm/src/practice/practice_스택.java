package practice;

import java.util.Stack;

public class practice_스택 {
	
	public static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		stack.add(2);
		stack.add(200);
		stack.add(400);
		boolean s = true;
			
		System.out.println("첫번째 값 : "+stack.peek());
		System.out.println("pop : " + stack.pop());
		System.out.println("pop : " + stack.pop());
		System.out.println("pop : " + stack.pop());
	}

}
