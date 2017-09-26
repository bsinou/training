package net.sinou.hackerrank.drafts.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListSort {

	static class Student {
		private int id;
		private String fname;
		private double cgpa;

		public Student(int id, String fname, double cgpa) {
			super();
			this.id = id;
			this.fname = fname;
			this.cgpa = cgpa;
		}

		public int getId() {
			return id;
		}

		public String getFname() {
			return fname;
		}

		public double getCgpa() {
			return cgpa;
		}
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int testCases = Integer.parseInt(in.nextLine());

			List<Student> studentList = new ArrayList<Student>();
			while (testCases > 0) {
				int id = in.nextInt();
				String fname = in.next();
				double cgpa = in.nextDouble();

				Student st = new Student(id, fname, cgpa);
				studentList.add(st);

				testCases--;
			}

			Comparator<Student> comp = new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					int result = (int) (o2.cgpa * 100d) - (int) (o1.cgpa * 100);
					if (result == 0)
						result = o1.fname.compareTo(o2.fname);
					if (result == 0)
						result = o1.id - o2.id;
					return result;
				}
			};

			// Java 7 syntax
			Collections.sort(studentList, comp);
			// Java 8 syntax
			studentList.sort(comp);
			// Other with functional programming
			Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed()
					.thenComparing(Student::getFname).thenComparing(Student::getId));

			for (Student st : studentList) {
				System.out.println(st.getFname());
			}
		}
	}

}
