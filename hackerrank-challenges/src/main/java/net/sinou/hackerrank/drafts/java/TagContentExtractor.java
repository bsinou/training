package net.sinou.hackerrank.drafts.java;

import java.util.Scanner;
import java.util.Stack;

public class TagContentExtractor {

	private static Stack<String> tags;

	private static void parseLine(String lineStr) {
		StringBuilder line = new StringBuilder(lineStr);
		tags = new Stack<>();
		String currContent = "";
		while (line.length() > 0) {
			int startIndex = line.indexOf("<");
			int endIndex = line.indexOf(">");
			if (startIndex == 0) {
				if (line.charAt(1) == '/') {
					String tag = line.substring(2, endIndex);
					if (tag.equals(tags.pop()) & currContent.length() > 0) {
						System.out.println(currContent);
					}
				} else {
					tags.push(line.substring(1, endIndex));

				}
				currContent = "";
				line.delete(0, endIndex + 1);
			} else {
				currContent = line.substring(0, startIndex);
				line.delete(0, startIndex);
			}
		}
	}

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int testCases = Integer.parseInt(in.nextLine());
			while (testCases > 0) {
				parseLine(in.nextLine());
				testCases--;
			}
		}
	}
}
