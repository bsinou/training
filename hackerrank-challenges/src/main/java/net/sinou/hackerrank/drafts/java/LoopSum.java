package net.sinou.hackerrank.drafts.java;

import java.util.Scanner;

public class LoopSum {

	public static void main(String[] argh) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			for (int i = 0; i < t; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int n = in.nextInt();
				for (int j = 0; j < n; j++) {
					a = a + (1 << j) * b;
					System.out.print(a + (j == n - 1 ? "\n" : " "));
				}
			}
			in.close();
		}
	}

	public static void test(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				try {
					long x = sc.nextLong();
					System.out.println(x + " can be fitted in:");
					if (x >= Byte.MIN_VALUE && Byte.MAX_VALUE <= 127)
						System.out.println("* byte");
					if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE)
						System.out.println("* short");
					if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE)
						System.out.println("* short");
					if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE)
						System.out.println("* short");
				} catch (Exception e) {
					System.out.println(sc.next() + " can't be fitted anywhere.");
				}
			}
		}
	}
}
