package net.sinou.hackerrank.drafts;

import java.util.Scanner;
import java.util.Stack;

public class Brackets {

	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
		loop: for (char currBracket : expression.toCharArray()) {
			if (currBracket == '[' || currBracket == '{' || currBracket == '(') {
				stack.push(currBracket);
			} else {
				char top = stack.pop();
				if (currBracket == ']') {
					if (top == '[')
						continue loop;
					else
						return false;
				} else if (currBracket == '}') {
					if (top == '{')
						continue loop;
					else
						return false;
				} else if (currBracket == ')') {
					if (top == '(')
						continue loop;
					else
						return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				String expression = in.next();
				System.out.println((isBalanced(expression)) ? "YES" : "NO");
			}
		}
	}
}