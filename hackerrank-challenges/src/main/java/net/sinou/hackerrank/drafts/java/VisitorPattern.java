package net.sinou.hackerrank.drafts.java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	private int result = 0;

	public int getResult() {
		return result;
	}

	public void visitNode(TreeNode node) {
	}

	public void visitLeaf(TreeLeaf leaf) {
		result += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {
	private long result = 1;

	public int getResult() {
		return (int) result;
	}

	private void visit(Tree node) {
		if (node.getColor() == Color.RED)
			result = (result * node.getValue()) % (1000000007);
	}

	public void visitNode(TreeNode node) {
		visit(node);
	}

	public void visitLeaf(TreeLeaf leaf) {
		visit(leaf);
	}
}

class FancyVisitor extends TreeVis {
	private int a = 0, b = 0;

	public int getResult() {
		return Math.abs(a - b);
	}

	public void visitNode(TreeNode node) {
		if (node.getDepth() % 2 == 0)
			a += node.getValue();
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.GREEN)
			b += leaf.getValue();
	}
}

class CountVisitor extends TreeVis {
	private int nb = 0;

	public int getResult() {
		return nb;
	}

	public void visitNode(TreeNode node) {
		nb++;
	}

	public void visitLeaf(TreeLeaf leaf) {
		nb++;
	}
}

/**
 * Convenient class that store the initial id of a node to ease building of the
 * tree
 */
class TreeNodeId extends TreeNode {
	private final int id;

	public TreeNodeId(int value, Color color, int depth, int id) {
		super(value, color, depth);
		this.id = id;
	}

	public int getId() {
		return id;
	}
}

public class VisitorPattern {

	public static Tree solve() {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int[] weights = new int[n];
			Color[] colors = new Color[n];

			for (int i = 0; i < n; i++)
				weights[i] = in.nextInt();
			for (int i = 0; i < n; i++)
				colors[i] = in.nextInt() == 0 ? Color.RED : Color.GREEN;

			Map<Integer, Set<Integer>> edges = new HashMap<>();

			// We retrieve the edges: we cannot directly create the tree because Node and
			// Leaf must be differentiated
			for (int i = 0; i < n - 1; i++) {
				int fromIndex = in.nextInt() - 1;
				int toIndex = in.nextInt() - 1;
				if (!edges.containsKey(fromIndex))
					edges.put(fromIndex, new HashSet<Integer>());
				edges.get(fromIndex).add(toIndex);

				// We store edges in both direction
				if (!edges.containsKey(toIndex))
					edges.put(toIndex, new HashSet<Integer>());
				edges.get(toIndex).add(fromIndex);
			}

			// Corner case: root has no child
			if (n == 1)
				return new TreeLeaf(weights[0], colors[0], 0);

			// create root
			Deque<TreeNodeId> queue = new LinkedList<TreeNodeId>();
			TreeNodeId root = new TreeNodeId(weights[0], colors[0], 0, 0);
			queue.addLast(root);

			while (!queue.isEmpty()) {
				TreeNodeId parent = queue.pop();
				Set<Integer> children = edges.get(parent.getId());
				for (int currIndex : children) {
					// Remove the stored other direction edge
					Set<Integer> otherEdges = edges.get(currIndex);
					otherEdges.remove(parent.getId());
					if (otherEdges.isEmpty())
						edges.remove(currIndex);

					// Leaf
					if (!edges.containsKey(currIndex)) {
						TreeLeaf leaf = new TreeLeaf(weights[currIndex], colors[currIndex], parent.getDepth() + 1);
						parent.addChild(leaf);
					} else {
						TreeNodeId child = new TreeNodeId(weights[currIndex], colors[currIndex], parent.getDepth() + 1,
								currIndex);
						parent.addChild(child);
						queue.addLast(child);
					}

				}

			}
			checkTree(root, n);
			return root;
		}
	}

	private static void checkTree(Tree tree, int nbOfNode) {
		CountVisitor cv = new CountVisitor();
		tree.accept(cv);
		System.out.println("Tree solved with " + nbOfNode + " nodes, tree size: " + cv.getResult());

	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
