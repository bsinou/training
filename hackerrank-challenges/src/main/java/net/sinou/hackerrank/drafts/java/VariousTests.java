package net.sinou.hackerrank.drafts.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/** Various patterns and tests */
public class VariousTests {

	static <T> Iterator<T> func(ArrayList<T> mylist) {
		Iterator<T> it = mylist.iterator();
		while (it.hasNext()) {
			Object element = it.next();
			if (element instanceof String && "###".equals((String) element))
				break;
		}
		return it;
	}

	static String upperFirst(String s) {
		if (s.length() == 0)
			return s;
		else if (s.length() == 1)
			return s.toUpperCase();
		else
			return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	static void bigIntegersManipulation() {
		try (Scanner in = new Scanner(System.in)) {
			BigInteger a = new BigInteger(in.next());
			BigInteger b = new BigInteger(in.next());
			System.out.println(a.add(b).toString());
			System.out.println(a.multiply(b).toString());
		}
	}

	static void listManipulation() {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(in.nextInt());
			}
			n = in.nextInt();
			for (int i = 0; i < n; i++) {
				String command = in.next();
				if (command.equals("Delete"))
					list.remove(in.nextInt());
				else
					list.add(in.nextInt(), in.nextInt());
			}

			StringBuilder builder = new StringBuilder();
			for (int val : list)
				builder.append(val + " ");
			System.out.println(builder.length() > 0 ? builder.substring(0, builder.length() - 1) : "");
		}
	}

	static void dummyPhoneBook() {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			in.nextLine();
			HashMap<String, Integer> book = new HashMap<>(n);
			for (int i = 0; i < n; i++) {
				String name = in.nextLine();
				int phone = in.nextInt();
				in.nextLine();
				book.put(name, phone);
			}
			while (in.hasNext()) {
				String s = in.nextLine();
				Integer res = book.get(s);
				if (res == null)
					System.out.println("Not found");
				else
					System.out.printf("%s=%d%n", s, res.intValue());
			}
		}
	}

	static boolean isBalancedStrings(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '}' || c == ']' || c == ')') {
				if (stack.isEmpty() || c != stack.pop())
					return false;
			} else if (c == '{')
				stack.push('}');
			else if (c == '(')
				stack.push(')');
			else if (c == '[')
				stack.push(']');
		}
		return stack.isEmpty();
	}

	static void dummyPairs() {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			String[] pair_left = new String[t];
			String[] pair_right = new String[t];

			for (int i = 0; i < t; i++) {
				pair_left[i] = in.next();
				pair_right[i] = in.next();
			}

			Set<String> set = new HashSet<>();
			for (int i = 0; i < t; i++) {
				set.add(pair_left[i] + " " + pair_right[i]);
				System.out.println(set.size());
			}
		}
	}

	static class PlayerComparator implements Comparator<Player> {
		@Override
		public int compare(Player o1, Player o2) {
			int result = o1.name.compareTo(o2.name);
			if (result == 0)
				return o1.score - o2.score;
			else
				return result;
		}

	}

	class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

}
