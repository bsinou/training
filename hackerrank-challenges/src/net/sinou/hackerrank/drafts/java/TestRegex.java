package net.sinou.hackerrank.drafts.java;

import java.util.Scanner;

public class TestRegex {

	private static String nb = "((0?0?[0-9])|(0?[1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))";
	// public static String pattern = "["+nb + "\\.]{3}" + nb;
	public static String pattern = nb + "\\." + nb + "\\." + nb + "\\." + nb;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String pat = "(0?0?[0-9])|(0?[1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5])";
			while (in.hasNextLine()) {
				String nextLine = in.nextLine();
				System.out.println(nextLine + " matches '" + pattern + "': " + nextLine.matches(pattern));
				System.out.println(nextLine + ": " + nextLine.matches(pattern));
				System.out.println(nextLine + ": " + nextLine.matches(pat));
			}
		}
	}

}
