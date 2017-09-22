package net.sinou.hackerrank.drafts.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/** Various String manipulation problems */
public class StringProblems {

	static void validatePattern(String regex) {
		try {
			Pattern.compile(regex);
			System.out.println("Valid");
		} catch (PatternSyntaxException e) {
			System.out.println("Invalid");
		}
	}

	static void splitToken(String s) {
		String pattern = "[^a-zA-Z]+";
		String[] tokens = s.split(pattern);
		String[] filteredToken = Arrays.stream(tokens).filter(t -> t.length() > 0).toArray(String[]::new);
		System.out.println("" + filteredToken.length);
		for (String token : filteredToken)
			System.out.println(token);
	}

	static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		if (k >= 1) {
			for (int i = 0; i <= s.length() - k; i++) {
				String curr = s.substring(i, i + k);
				if ("".equals(smallest)) {
					smallest = curr;
					largest = curr;
				} else {
					if (curr.compareTo(smallest) < 0)
						smallest = curr;
					if (curr.compareTo(largest) > 0)
						largest = curr;
				}
			}
		}
		return smallest + "\n" + largest;
	}

	static boolean isPalindrome(String s) {
		boolean isPalindrome = true;
		int l = s.length();
		for (int i = 0; i <= l / 2; i++)
			if (s.charAt(i) != s.charAt(l - i - 1)) {
				isPalindrome = false;
				break;
			}
		return isPalindrome;
	}

	static boolean isAnagram(String a, String b) {
		Map<Integer, Integer> letters = new HashMap<>();
		a.chars().forEach(letter -> letters.compute(letter, (k, v) -> v == null ? 1 : ++v));
		b.chars().forEach(letter -> letters.compute(letter, (k, v) -> v == null ? -1 : --v));
		Optional<Integer> res = letters.keySet().stream().filter(k -> letters.get(k) != 0).findAny();
		return !res.isPresent();
	}

	static boolean isAnagramOld(String a, String b) {
		Map<Character, Integer> letters = new HashMap<>();
		for (char c : a.toLowerCase().toCharArray()) {
			if (!letters.containsKey(c))
				letters.put(c, 1);
			else
				letters.put(c, letters.get(c) + 1);
		}
		for (char c : b.toLowerCase().toCharArray()) {
			if (!letters.containsKey(c))
				letters.put(c, -1);
			else
				letters.put(c, letters.get(c) - 1);
		}
		Optional<Character> res = letters.keySet().stream().filter(k -> letters.get(k) != 0).findAny();
		return !res.isPresent();
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			// smallest
			// String s = scan.next();
			// int k = scan.nextInt();
			// System.out.println(getSmallestAndLargest(s, k));

			// Palindrome
			// String s = scan.next();
			// System.out.println(isPalindrome(s));

			// Anagram
			// String s = scan.next();
			// String t = scan.next();
			// System.out.println(isAnagram(s, t));

			// Tokens
			String s = scan.nextLine();
			splitToken(s);
		}
	}
}
