package treesandgraphs;

public class DepthFirstSearch {
	public static class Node {
		public Node[] children;
		public boolean visited = false;
		public String val;
	}

	// O(n) - each node is visited exactly once
	public static void dfs(Node root) {
		if (root == null) return;

		// visit this node
		System.out.println("visited this node");
		root.visited = true;

		for (Node child : root.children)
			if (!child.visited) dfs(child);
	}


}
