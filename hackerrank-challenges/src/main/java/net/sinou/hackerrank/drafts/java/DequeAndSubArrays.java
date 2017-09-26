package net.sinou.hackerrank.drafts.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DequeAndSubArrays {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			Deque<Integer> deque = new ArrayDeque<>();
			int n = in.nextInt();
			int m = in.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			boolean unstack = false;
			int max = 0;
			for (int i = 0; i < n; i++) {
				int num = in.nextInt();

				// Fill the deque and counting map
				deque.add(num);
				if (map.containsKey(num))
					map.put(num, map.get(num) + 1);
				else
					map.put(num, 1);

				if (unstack) {
					// rotate the deque and the counting map
					int old = deque.pop();
					int nb = map.get(old);
					if (nb == 1)
						map.remove(old);
					else
						map.put(old, nb - 1);
					max = Math.max(max, map.size());
				} else {
					// init phase
					if (deque.size() == m) {
						unstack = true;
						max = map.size();
					}
				}
			}
			// Result
			System.out.println(max);
		}
	}
}
