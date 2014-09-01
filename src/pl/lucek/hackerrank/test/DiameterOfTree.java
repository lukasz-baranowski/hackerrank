package pl.lucek.hackerrank.test;

import java.util.Scanner;

public class DiameterOfTree {

	public static void main(final String[] args) {
		final Scanner in = new Scanner(System.in);
		Node _root;
		int root_i = 0, root_cnt = 0, root_num = 0;
		_root = null;
		final int isBst = in.nextInt();
		root_cnt = in.nextInt();
		for (root_i = 0; root_i < root_cnt; root_i++) {
			root_num = in.nextInt();
			if (isBst == 0) {
				_root = addRandomElement(_root, root_num, root_i);
			} else {
				_root = insert(_root, root_num);
			}
		}
		System.out.println(diameterOfTree(_root));

		in.close();
		return;
	}

	/* Write your custom functions here */
	static int diameterOfTree(final Node root) {
		/* For your reference
		   class Node {
		       Node left, right;
		       int data;
		               Node(int newData) {
		           left = right = null;
		           data = newData;
		       }
		   }
		*/
		
	    if (root == null)
	        return 0;

	    final int rootDiameter = getHeight(root.left) + getHeight(root.right) + 1;
	    final int leftDiameter = diameterOfTree(root.left);
	    final int rightDiameter = diameterOfTree(root.right);

	    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	public static int getHeight(final Node root) {
	    if (root == null)
	        return 0;

	    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	private static class Node {
		Node left, right;
		int data;
		Node(final int newData) {
			left = right = null;
			data = newData;
		}
	}

	private static Node insert(Node node, final int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data < node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return (node);
	}

	private static Node addRandomElement(Node node, final int data,
			final int index) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (index <= 2) {
				node.left = addRandomElement(node.left, data, index);
			} else {
				node.right = addRandomElement(node.right, data, index);
			}
		}
		return (node);
	}

}
