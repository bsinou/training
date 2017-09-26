package net.sinou.hackerrank.drafts.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student implements Comparable<Student> {
	private int id;
	private String name;
	private double cgpa;

	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public int compareTo(Student o2) {
		int result = (int) (o2.getCgpa() * 1000d) - (int) (this.getCgpa() * 1000d);
		if (result == 0)
			result = this.name.compareTo(o2.getName());
		if (result == 0)
			result = this.id - o2.getId();
		return result;
	}
}

class Priorities {

	public List<Student> getStudents(List<String> events) {
		PriorityQueue<Student> queue = new PriorityQueue<>();
		for (String event : events) {
			if (event.startsWith("SERVED"))
				queue.poll();
			else {
				String[] params = event.split(" ");
				queue.add(new Student(Integer.valueOf(params[3]), params[1], Double.valueOf(params[2])));
			}
		}
		List<Student> result = Arrays.asList(queue.toArray(new Student[queue.size()]));
		Collections.sort(result);
		return result;
	}
}

public class LunchQueue {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}

}
