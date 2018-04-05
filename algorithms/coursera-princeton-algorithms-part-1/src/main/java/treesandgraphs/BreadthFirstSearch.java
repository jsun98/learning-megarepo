package treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	public static class Node {
		public Node[] children;
		public boolean visited = false;
		public String val;
	}

	// O(n)
	public static void bfs (Node root) {
		if (root == null) return;
		root.visited = true;

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node node = q.poll();
			node.visited = true;
			for (Node child : root.children) {
				if (!child.visited) {
					child.visited = true;
					q.add(child);
				}

			}
		}

	}
}
