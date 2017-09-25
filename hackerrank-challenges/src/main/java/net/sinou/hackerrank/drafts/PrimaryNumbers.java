package net.sinou.hackerrank.drafts;

import java.util.Scanner;

public class PrimaryNumbers {

	static boolean isPrimary(int n) {
		if (n == 0 || n == 1)
			return true;
		for (int i = 2; i * i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int p = in.nextInt();
			for (int a0 = 0; a0 < p; a0++) {
				System.out.println(isPrimary(in.nextInt()) ? "Prime" : "Not prime");
			}
		}
	}
}
