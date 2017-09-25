package net.sinou.hackerrank.drafts;

import java.util.Scanner;

public class MergeSort {

	public static void mergeSort(int[] array) {
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int[] tmp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd)
			return;
		int mid = (leftStart + rightEnd) / 2;
		mergeSort(array, tmp, leftStart, mid);
		mergeSort(array, tmp, mid + 1, rightEnd);
		mergeHalves(array, tmp, leftStart, rightEnd);
	}

	private static void mergeHalves(int[] array, int[] tmp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				tmp[index] = array[left];
				left++;
			} else {
				tmp[index] = array[right];
				right++;
			}
			index++;
		}
		// copy remaining largest objects into the temp
		System.arraycopy(array, left, tmp, index, leftEnd - left + 1);
		System.arraycopy(array, right, tmp, index, rightEnd - right + 1);
		System.arraycopy(tmp, leftStart, array, leftStart, size);
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			mergeSort(a);
			for (int curr : a) {
				System.out.print(curr + " ");
			}
			System.out.println("");
		}
	}

}
