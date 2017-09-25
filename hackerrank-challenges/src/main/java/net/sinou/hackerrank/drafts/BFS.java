package net.sinou.hackerrank.drafts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BFS {

	// public static void main(String... args) {
	//
	// Scanner in = new Scanner(System.in);
	//
	// int queryNb = new Integer(in.next());
	//
	// for (int i = 0; i < queryNb; i++) {
	//
	// }
	// }

	public static void main(String... args) {
		Graph graph = new Graph();
		int nodeNb = new Integer(args[0]);
		int edgeNb = new Integer(args[1]);

		for (int i = 1; i <= nodeNb; i++) {
			graph.addNode(i);
		}

		for (int i = 0; i < edgeNb; i++) {
			graph.addEdge(new Integer(args[2 + i * 2]), new Integer(args[2 + i * 2 + 1]));
		}

		int startingPoint = new Integer(args[2 + edgeNb * 2]);

		for (int i = 1; i <= nodeNb; i++) {
			if (i == startingPoint)
				continue;
			System.out.println("" + graph.shortestPath(startingPoint, i));
		}
	}

	private static class Graph {
		private HashMap<Integer, Node> nodeLookup = new HashMap<>();

		public static class Node {
			private int id;

			LinkedList<Node> adjacent = new LinkedList<>();

			public Node(int id) {
				this.id = id;
			}
		}

		private Node getNode(int id) {
			return nodeLookup.get(id);
		}

		public void addNode(int data) {
			nodeLookup.put(data, new Node(data));
		}

		public void addEdge(int source, int dest) {
			Node s = getNode(source);
			Node d = getNode(dest);
			s.adjacent.add(d);
			d.adjacent.add(s);
		}

		public int shortestPath(int source, int dest) {
			return shortestPath(getNode(source), getNode(dest));
		}

		public int shortestPath(Node source, Node dest) {
			LinkedList<Node> nextToVisit = new LinkedList<>();
			HashSet<Integer> visited = new HashSet<>();
			nextToVisit.add(source);

			int shortestDistance = 0;
			int nbOfThisLevelNodes = 1;
			int nbOfNextLevelNodes = 0;

			while (!nextToVisit.isEmpty()) {
				Node currNode = nextToVisit.remove();
				nbOfThisLevelNodes--;

				if (currNode == dest)
					return shortestDistance * 6;

				if (!visited.contains(currNode.id)) {
					visited.add(currNode.id);
					for (Node child : currNode.adjacent)
						nextToVisit.add(child);
					nbOfNextLevelNodes += currNode.adjacent.size();
				}

				if (nbOfThisLevelNodes == 0) {
					nbOfThisLevelNodes = nbOfNextLevelNodes;
					shortestDistance++;
					nbOfNextLevelNodes = 0;
				}

			}
			return -1;
		}
	}
}
