package net.sinou.hackerrank.drafts;

import java.util.Scanner;

public class Swaps {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			long result = countInversions(arr);
			System.out.println(result);

			long result2 = mergeSort(arr);
			System.out.println(result2);
		}
		in.close();
	}

	/** Basic solution, time out for most of the test cases */
	static private long countInversions(int[] arr) {
		long count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++)
				if (arr[i] > arr[j])
					count++;
		}
		return count;
	}

	/** Use merge sort */
	public static long mergeSort(int[] array) {
		return mergeSort(array, new int[array.length], 0, array.length - 1);
	}

	private static long mergeSort(int[] array, int[] tmp, int leftStart, int rightEnd) {

		if (leftStart >= rightEnd)
			return 0L;
		int mid = (leftStart + rightEnd) / 2;

		long swaps = mergeSort(array, tmp, leftStart, mid);
		swaps += mergeSort(array, tmp, mid + 1, rightEnd);
		swaps += mergeHalves(array, tmp, leftStart, rightEnd);
		return swaps;
	}

	private static long mergeHalves(int[] array, int[] tmp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		long swaps = 0;

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				tmp[index] = array[left];
				left++;
			} else {
				tmp[index] = array[right];
				right++;
				swaps += leftEnd - left + 1;
			}
			index++;
		}

		// copy remaining largest objects into the temp
		System.arraycopy(array, left, tmp, index, leftEnd - left + 1);
		System.arraycopy(array, right, tmp, index, rightEnd - right + 1);
		System.arraycopy(tmp, leftStart, array, leftStart, size);
		return swaps;
	}

}
