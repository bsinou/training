package net.sinou.hackerrank.drafts;

import java.util.Scanner;

public class DiagSum {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();

			long d1 = 0, d2 = 0;
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					int curr = in.nextInt();
					if (row==col)
						d1 += curr;
					if (row+col==n-1)
						d2 += curr;
				}
			}
			System.out.println(Math.abs(d1-d2));
		}
	}
}
