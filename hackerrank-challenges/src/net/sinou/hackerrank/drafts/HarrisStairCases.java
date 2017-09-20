package net.sinou.hackerrank.drafts;

import java.util.Scanner;

public class HarrisStairCases {

	private static void solve(int[] stairCases) {
		int max = 0;
		for (int nbOfStairs : stairCases)
			max = Math.max(max, nbOfStairs);
		int[] solutions = new int[max + 1];
		solutions[0] = 1;

		loop: for (int k = 1; k<max+1;k++) {
			for (int j = 1; j<4; j++) {
				if (k-j < 0)
					continue loop;
				else 
					solutions[k] +=  solutions[k-j]; 

			}
		}
		for (int nbOfStairs : stairCases)
			System.out.println(solutions[nbOfStairs]);
	}
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int s = in.nextInt();
			int[] a  = new int[s];
			for (int a0 = 0; a0 < s; a0++) {
				a[a0] = in.nextInt();
			}
			solve(a);
		}
	}
}
