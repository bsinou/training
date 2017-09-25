package net.sinou.hackerrank.drafts.java;

import java.util.Scanner;

public class OneDArrayGame {
	public static boolean canWin(int leap, int[] game) {
		int[] passedPositions = new int[game.length];
		return canReachTheEnd(0, passedPositions, leap, game);
	}

	private static boolean canReachTheEnd(int currPos, int[] passedPositions, int leap, int[] arr) {
		if (currPos == arr.length - 1 || currPos > arr.length - 1 - leap)
			return true;
		if (passedPositions[currPos] == 1)
			return false;
		else
			passedPositions[currPos] = 1;

		return (arr[currPos + leap] == 0 && canReachTheEnd(currPos + leap, passedPositions, leap, arr))
				|| (arr[currPos + 1] == 0 && canReachTheEnd(currPos + 1, passedPositions, leap, arr))
				|| (currPos > 1 && arr[currPos - 1] == 0 && canReachTheEnd(currPos - 1, passedPositions, leap, arr));

	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int q = scan.nextInt();
			while (q-- > 0) {
				int n = scan.nextInt();
				int leap = scan.nextInt();

				int[] game = new int[n];
				for (int i = 0; i < n; i++) {
					game[i] = scan.nextInt();
				}

				System.out.println((canWin(leap, game)) ? "YES" : "NO");
			}
		}
	}
}
