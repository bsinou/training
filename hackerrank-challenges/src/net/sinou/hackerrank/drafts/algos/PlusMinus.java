package net.sinou.hackerrank.drafts.algos;

import java.util.Scanner;

public class PlusMinus {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int pos = 0, neg = 0, zeros = 0;
			for (int i = 0; i < n; i++) {
				int curr = in.nextInt();
				if (curr > 0)
					pos++;
				else if (curr < 0)
					neg++;
				else
					zeros++;
			}
			print(pos, n);
			print(neg, n);
			print(zeros, n);
		}
	}

	private static void print(int num, int den) {
		double res = (double) num / (double) den;
		System.out.printf("%.6f%n", res);
	}
}
