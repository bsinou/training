package net.sinou.hackerrank.drafts.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateFormatting {

	private static void printDayOfWeek(String day, String month, String year) {
		// With Calendar
		Calendar cal = new GregorianCalendar((new Integer(year)).intValue(), (new Integer(month)).intValue() - 1,
				(new Integer(day)).intValue());
		// Equivalent formating
		String result = String.format("%TA", cal);
		System.out.println(result);
		// Same but direct
		System.out.printf("%TA", cal);

		// With LocalDate (Java 8)
		String result2 = String.format("%TA", LocalDate.of((new Integer(year)).intValue(),
				(new Integer(month)).intValue(), (new Integer(day)).intValue()));
		System.out.println(result2);
	}

	/** Convert from AM/PM to 24 hours format */
	private static String timeConversion(String s) {
		DateFormat df1 = new SimpleDateFormat("hh:mm:ssa");
		DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
		try {
			return df2.format(df1.parse(s));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Cannot parse " + s, e);
		}
	}

	public static void main(String[] args) {
		printDayOfWeek("20", "09", "2017");

		try (Scanner in = new Scanner(System.in)) {
			String s = in.next();
			String result = timeConversion(s);
			System.out.println(result);
		}
	}
}
