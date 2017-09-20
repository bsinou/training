package net.sinou.hackerrank.drafts.algos;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxSum {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int[] arr = new int[5];
			for (int arr_i = 0; arr_i < 5; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			int min = Arrays.stream(arr).min().getAsInt();
			int max = Arrays.stream(arr).max().getAsInt();
			long sum = Arrays.stream(arr).mapToLong(c -> (long)c).sum();
			System.out.println((sum-max) + " " + (sum-min));
		}
	}

}
