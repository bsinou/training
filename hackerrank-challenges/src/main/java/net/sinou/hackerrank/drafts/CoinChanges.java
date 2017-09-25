package net.sinou.hackerrank.drafts;

import java.util.Arrays;

public class CoinChanges {

	public static void main(String[] args) {
		int n = new Integer(args[0]);
		int m = new Integer(args[1]);
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = new Integer(args[coins_i + 2]);
		}

		Arrays.sort(coins);
		System.out.println("" + solve(coins, n));

	}

	public static long solve(int[] coins, int amount) {
		long[] solutions = new long[amount + 1];
		solutions[0] = (long) 1;
		for (int currCoin : coins) {
			for (int j = currCoin; j < solutions.length; j++) 
				solutions[j] += solutions[j - currCoin];
			
		}
		return solutions[amount];
	}

	@SuppressWarnings("unused")
	private static class Solution {
		private final int[] coins;
		private final int nbOfCoins;
		private Integer[] solutions;

		public Solution(int nbOfCoins, int[] coins) {
			this.nbOfCoins = nbOfCoins;
			this.coins = Arrays.copyOf(coins, nbOfCoins);
			Arrays.sort(coins);
		}

		public int solve(int total) {
			int nbOfResult = 0;
			loop: for (int currCoin : coins) {
				int subTotal = total - currCoin;
				if (subTotal < 0)
					continue loop;
				else if (subTotal == 0) {
					nbOfResult++;
					continue loop;
				} else if (solutions[subTotal] != null) {
					nbOfResult += solutions[subTotal];
					continue loop;
				} else {
					int subResult = solve(subTotal);
					solutions[subTotal] = subResult;
					nbOfResult += subResult;
				}
			}
			return nbOfResult;
		}
	}
}
