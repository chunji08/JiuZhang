package com.project.jz.BinaryTree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree_DFS_BFS {
	public static void main(String... args) {
		TreeNode root = initialize();
		System.out.println("\nPreOrder DFS: ");
		preOrderDFS(root);
		System.out.println("\nInOrder DFS");
		inOrderDFS(root);
		System.out.println("\nPostOrder DFS");
		postOrderDFS(root);
		System.out.println("\nOrder level BFS");
		orderBFS(root);
		System.out.println("\nOrder ZIGZAG BFS");
		orderZigZagBFS(root);
		System.out.println();

		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		root = createMinimal(array, 0, 8);

		System.out.println("\nOrder level BFS");
		orderBFS(root);
		System.out.println("\nPreOrder DFS: ");
		preOrderDFS(root);
		System.out.println("\nInOrder DFS");
		inOrderDFS(root);
		System.out.println("\nPostOrder DFS");
		postOrderDFS(root);

	}

	public static void orderZigZagBFS(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> currentLevelStack = new Stack<TreeNode>();
		boolean L2R = true;
		currentLevelStack.add(root);

		while (!currentLevelStack.isEmpty()) {
			TreeNode current = currentLevelStack.pop();

			System.out.print(current.val + "\t");
			if (L2R) {
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			} else {
				if (current.right != null)
					queue.add(current.right);
				if (current.left != null)
					queue.add(current.left);
			}

			if (currentLevelStack.isEmpty()) {
				L2R = !L2R;
				while (!queue.isEmpty()) {
					currentLevelStack.add(queue.poll());
				}
			}
		}
	}

	public static void preOrderDFS(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + "\t");
		preOrderDFS(root.left);
		preOrderDFS(root.right);
	}

	public static void inOrderDFS(TreeNode root) {
		if (root == null)
			return;
		inOrderDFS(root.left);
		System.out.print(root.val + "\t");
		inOrderDFS(root.right);
	}

	public static void postOrderDFS(TreeNode root) {
		if (root == null)
			return;
		postOrderDFS(root.left);
		postOrderDFS(root.right);
		System.out.print(root.val + "\t");
	}

	public static void orderBFS(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.print(current.val + "\t");
			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}
	}

	public static TreeNode createMinimal(int[] array, int start, int end) {
		if (end < start)
			return null;

		int mid = (end + start) / 2;

		TreeNode root = new TreeNode(array[mid]);
		root.left = createMinimal(array, start, mid - 1);
		root.right = createMinimal(array, mid + 1, end);
		return root;
	}

	public static TreeNode initialize() {
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(5);
		TreeNode tn6 = new TreeNode(6);
		TreeNode tn7 = new TreeNode(7);
		TreeNode tn8 = new TreeNode(8);
		TreeNode tn9 = new TreeNode(9);
		TreeNode tn10 = new TreeNode(10);
		TreeNode tn11 = new TreeNode(11);
		TreeNode tn12 = new TreeNode(12);
		TreeNode tn13 = new TreeNode(13);
		TreeNode tn14 = new TreeNode(14);
		TreeNode tn15 = new TreeNode(15);
		TreeNode tn16 = new TreeNode(16);
		TreeNode tn17 = new TreeNode(17);
		TreeNode tn18 = new TreeNode(18);

		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.left = tn6;
		tn3.right = tn7;
		tn4.left = tn8;
		tn4.right = tn9;
		tn5.left = tn10;
		tn5.right = tn11;
		tn6.left = tn12;
		tn6.right = tn13;
		tn7.left = tn14;
		tn7.right = tn15;
		tn8.left = tn16;
		tn8.right = tn17;
		tn9.left = tn18;

		return tn1;

	}
}