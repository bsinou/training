package net.sinou.hackerrank.drafts.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionManagement {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			manage(in.next(), in.next());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void manage(String xStr, String yStr) throws Exception {
		try {
			int x = new Integer(xStr).intValue();
			int y = new Integer(yStr).intValue();
			if (y == 0)
				throw new ArithmeticException("/ by zero");
			else
				System.out.println(x / y);
		} catch (NumberFormatException e) {
			throw new InputMismatchException();
			// System.out.println("java.util.InputMismatchException");
		}
	}
}
