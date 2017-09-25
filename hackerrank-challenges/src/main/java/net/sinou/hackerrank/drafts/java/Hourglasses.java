package net.sinou.hackerrank.drafts.java;

import java.util.Scanner;

public class Hourglasses {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int arr[][] = new int[6][6];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			for (int row = 0; row < 4; row++) {
				for (int col = 0; col < 4; col++) {
					max = Math.max(max, computeHourglass(arr, row, col));
				}
			}
			System.out.println(max+"");
		}
	}

	private static int computeHourglass(int[][] a, int row, int col) {
		int sum = a[row+1][col+1];
		for (int i = col; i<col+3;i++)
			sum+=a[row][i]+a[row+2][i];
		return sum;
	}
	
}
