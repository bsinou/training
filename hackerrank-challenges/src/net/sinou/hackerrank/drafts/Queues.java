package net.sinou.hackerrank.drafts;

import java.util.Scanner;

public class Queues {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}

	private static class MyQueue<T> {

		Node<T> head = null;
		Node<T> tail = null;

		public void enqueue(T elem) {
			Node<T> node = new Node<T>(elem);
			if (tail != null)
				tail.next = node;
			tail = node;
			if (head == null)
				head = tail;
		}

		public T dequeue() {
			if (head == null)
				throw new RuntimeException();

			T data = head.data;
			head = head.next;
			return data;
		}

		public T peek() {
			if (head == null)
				throw new RuntimeException();
			return head.data;
		}

	}

	private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}

	}
}
