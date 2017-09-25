package net.sinou.hackerrank.drafts;

import java.util.Scanner;

public class LonelyInteger {

	
	private static void solve(int[] a){
		int result = 0;
		for (int item : a) {
			result ^= item;
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			solve(a);
		}
	}
}
