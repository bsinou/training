package net.sinou.hackerrank.drafts.algos;

import java.util.Scanner;

public class Staircase {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < n; i++)
				builder.append(" ");			
			for (int i = 1; i <= n; i++) {
				builder.replace(n-i, n-i+1, "#");
				System.out.println(builder.toString());
			}
		}
	}
}
