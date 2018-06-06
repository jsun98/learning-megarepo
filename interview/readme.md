# Technical Interview Cheat Sheet

## Graph
Definition:
1. A finite set of **vertices** V
2. A finite set of ordered pair of the form (u, v) called **edge**. The pair is ordered because (u, v) is not same as (v, u) in case of a directed graph. The pair of the form (u, v) indicates that there is an edge from vertex u to vertex v. In case of an undirected graph, (u, v) and (v, u) are the same.

### Graph Representation

## Tree
Definition:
- has a root 
- directed acyclic graphs (in CS; in Graph Theory trees are assumed to be undirected)
- **there is only one path from root to any node in the tree**

Terminology:
- The **depth** of a node is the number of edges from the root to the node.
- The **height** of a node is the number of edges from the node to the deepest leaf.
- The **height** of a tree is a height of the root.

## Binary Tree
Definition: a **tree** in which every node has 0, 1, or 2 children

Types:
1. **full binary tree**: every node has 0 or 2 children
2. **complete binary tree**: every level of the tree is filled except for the last, which is filled left to right
3. **perfect binary tree**: full and complete 

insert, remove, search: in general O(h), worst case O(n) for a degenerate tree

### Binary Search Tree
Definition:
- is a binary tree
- key of left node is smaller than parent's key
- key of right node is greater than parent's key
- there can be no duplicate keys

unbalanced BST (not full)
insert, remove, search: O(n)

balanced BST (AVL, Red-black, full tree)
insert, remove, search: O(log n)

### Traversal Algorithms
#### 1. Depth First Search
- inorder (left, root, right), preorder (root, left, right), postorder (left, right, root)

Inorder example:
```java
void dfs(Node root) {
	if (root == null) return;
    dfs(root.left);
    // visit root
    dfs(root.right);
}   
```
time complexity: O(n), every node is visited exactly once

space complexity: O(n), function call stack has height n for a degenerate tree (linked list)
#### 2. Breadth First Search
```java
void bfs(Node root) {
	Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
    	Node tmp = q.remove();
        // visit tmp
        if (tmp.left != null)
        	q.add(tmp.left);
        if (tmp.right != null)
        	q.add(tmp.right);
   }
}
```
time complexity: O(n), every node is visited exactly once

space complexity: O(n), size of queue is equal to the maximum width of binary tree (left nodes), which is n/2 for a perfect binary tree

#### DFS vs BFS
- DFS uses more memory when tree is less balance, BFS uses more when tree is more balaneced
- DFS visits nodes down a path while BFS visits nodes level by level. Thus if target node is near top of the tree, use BFS, otherwise DFS.
- DFS requires recursion, which may be slow

## Other Topics
### Memory
#### Stack
- very fast access
- don't have to explicitly de-allocate variables
- space is managed efficiently by CPU, memory will not become fragmented
- local variables only (popped off after stack frame popped off)
- limit on stack size (OS-dependent)
- variables cannot be resized

#### Heap
- variables can be accessed globally
- no limit on memory size
- (relatively) slower access
- memory may become fragmented 
- need to free memory
