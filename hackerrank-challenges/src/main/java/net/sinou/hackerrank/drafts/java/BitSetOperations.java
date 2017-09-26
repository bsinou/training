package net.sinou.hackerrank.drafts.java;

import java.util.BitSet;
import java.util.Scanner;

public class BitSetOperations {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int m = in.nextInt();

			BitSet a = new BitSet(n);
			BitSet b = new BitSet(n);

			while (m-- > 0) {
				in.nextLine();
				String cmd = in.next();
				int p = in.nextInt();
				int q = in.nextInt();
				apply(a, b, cmd, p, q);
				System.out.printf("%d %d%n", a.cardinality(), b.cardinality());
			}
		}
	}

	private static void apply(BitSet a, BitSet b, String cmd, int p, int q) {
		if ("SET".equals(cmd)) {
			BitSet tmp = p == 1 ? a : b;
			tmp.set(q);
		} else if ("FLIP".equals(cmd)) {
			BitSet tmp = p == 1 ? a : b;
			tmp.flip(q);
		} else if ("AND".equals(cmd)) {
			BitSet a1 = p == 1 ? a : b;
			BitSet b1 = q == 1 ? a : b;
			a1.and(b1);
		} else if ("OR".equals(cmd)) {
			BitSet a1 = p == 1 ? a : b;
			BitSet b1 = q == 1 ? a : b;
			a1.or(b1);
		} else if ("XOR".equals(cmd)) {
			BitSet a1 = p == 1 ? a : b;
			BitSet b1 = q == 1 ? a : b;
			a1.xor(b1);
		}
	}
}
