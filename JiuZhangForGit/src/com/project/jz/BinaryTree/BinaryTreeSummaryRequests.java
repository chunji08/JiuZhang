package com.project.jz.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSummaryRequests {

	/* 
	 * Get the SUM of all bottom left nodes.
	 */
	public static int dfsLeftMostSum(TreeNode tn) {
		int sum = 0;
		if (tn == null)
			return 0;
		if (tn.left != null && tn.left.left != null) {
			sum += dfsLeftMostSum(tn.left);
		} else if (tn.left != null) {
			sum += tn.left.val;
		}

		if (tn.right != null && tn.right.left != null) {
			sum += dfsLeftMostSum(tn.right);
		}
		return sum;
	}

	/*
	 * Get the SUM of all bottom nodes.
	 */
	public static int dfsBottomNodesSum(TreeNode tn) {
		int sum = 0;
		if (tn == null) {
			return 0;
		}
		if (tn.left == null && tn.right == null)
			return tn.val;
		if (tn.left != null)
			sum += dfsBottomNodesSum(tn.left);
		if (tn.right != null)
			sum += dfsBottomNodesSum(tn.right);
		return sum;
	}

	/* 
	 * Get the sum of all shorted sum
	 */
	public static int dfsShortedSum(TreeNode tn) {
		if (tn == null) {
			return 0;
		}
		if (tn.left == null && tn.right == null) {
			return tn.val;
		} else if (tn.left != null && tn.right == null) {
			return tn.val + dfsShortedSum(tn.left);
		} else if (tn.left == null && tn.right != null) {
			return tn.val + dfsShortedSum(tn.right);
		} else {
			return tn.val
					+ Math.min(dfsShortedSum(tn.left), dfsShortedSum(tn.right));
		}
	}

	public static int dfsLongestSum(TreeNode tn) {
		if (tn == null)
			return 0;
		if (tn.left == null && tn.right == null) {
			return tn.val;
		} else if (tn.left == null && tn.right != null) {
			return tn.val + dfsLongestSum(tn.right);
		} else if (tn.left != null && tn.right == null) {
			return tn.val + dfsLongestSum(tn.left);
		} else {
			return tn.val
					+ Math.max(dfsLongestSum(tn.left), dfsLongestSum(tn.right));
		}
	}

	public static void main(String... args) {
		TreeNode tn1 = new TreeNode(20);
		TreeNode tn2 = new TreeNode(9);
		TreeNode tn3 = new TreeNode(49);
		TreeNode tn4 = new TreeNode(5);
		TreeNode tn5 = new TreeNode(12);
		TreeNode tn6 = new TreeNode(23);
		TreeNode tn7 = new TreeNode(52);
		TreeNode tn8 = new TreeNode(15);
		TreeNode tn9 = new TreeNode(50);

		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.left = tn6;
		tn3.right = tn7;
		tn5.right = tn8;
		tn7.left = tn9;

		treeBFS(tn1);
		System.out.println(dfsLeftMostSum(tn1));
		System.out.println(dfsBottomNodesSum(tn1));
		System.out.println(dfsShortedSum(tn1));
		System.out.println(dfsLongestSum(tn1));
	}

	public static void treeBFS(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode tn = queue.poll();
			System.out.print(tn.val + "\t");
			if (tn.left != null)
				queue.offer(tn.left);
			if (tn.right != null)
				queue.offer(tn.right);
		}
		System.out.println();
	}
}
