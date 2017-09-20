package net.sinou.hackerrank.drafts;

import java.util.Arrays;
import java.util.Scanner;

public class IceCreams {

	private int find(int[] items, int x, int i, int j) {
		if (i > j)
			return -1;
		int mid = i + (j - i) / 2;
		if (items[mid] == x)
			return x;
		else if (items[mid] > x)
			return find(items, x, i, mid - 1);
		else
			return find(items, x, mid + 1, j);
	}

	private void buy(int money, int[] prices) {
		int[] sorted = Arrays.copyOf(prices, prices.length);
		Arrays.sort(sorted);
		int firstPrice = 0;
		int secondPrice = 0;
		for (int i = 0; i < sorted.length - 1; i++) {
			firstPrice = sorted[i];
			secondPrice = find(sorted, money - firstPrice, i + 1, sorted.length - 1);
			if (secondPrice > 0)
				break;
		}

		// We want to print initial indexes (1 based) of the ice creams,
		// we assume only one solution is possible
		int i1 = 0, i2 = 0;
		for (int i = 0; i < prices.length; i++)
			if (prices[i] == firstPrice || prices[i] == secondPrice) {
				if (i1 == 0)
					i1 = i + 1;
				else {
					i2 = i + 1;
					break;
				}
			}

		System.out.println(i1 + " " + i2);
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			IceCreams ic = new IceCreams();
			for (int a0 = 0; a0 < t; a0++) {
				int m = in.nextInt();
				int n = in.nextInt();
				int a[] = new int[n];
				for (int a_i = 0; a_i < n; a_i++) {
					a[a_i] = in.nextInt();
				}
				ic.buy(m, a);
			}
		}
	}
}