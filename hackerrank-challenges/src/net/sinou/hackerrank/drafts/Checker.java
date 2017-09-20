package net.sinou.hackerrank.drafts;

import java.util.Comparator;

import net.sinou.hackerrank.drafts.Checker.Player;

public class Checker implements Comparator<Player> {

	@Override
	public int compare(Player a, Player b) {
		if (a == b)
			return 0;
		int scoreCmp = a.score - b.score;
		if (scoreCmp != 0)
			return -scoreCmp;
		else
			return a.name.compareTo(b.name);
	}

	class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

}