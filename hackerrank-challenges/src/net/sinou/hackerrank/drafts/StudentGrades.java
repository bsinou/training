package net.sinou.hackerrank.drafts;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;

public class StudentGrades {

	static int[] solve(int[] grades) {
		IntUnaryOperator func = i -> {
			if (i < 38)
				return i;
			else if ((i % 5) > 2)
				return i + (5 - i % 5);
			else
				return i;
		};
		return Arrays.stream(grades).map(func).toArray();
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int[] grades = new int[n];
			for (int grades_i = 0; grades_i < n; grades_i++) {
				grades[grades_i] = in.nextInt();
			}
			int[] result = solve(grades);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
			}
			System.out.println("");
		}
	}
}
