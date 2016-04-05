package baekjoon.S2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int row;
	static int col;
	static int[][] matrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();

		matrix = new int[row][col];

		sc.nextLine();

		for (int i = 0; i < row; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(line.charAt(j) + "");// == '0' ? 0 : 1;
			}
		}

		bfs(0, 0, 1);
	}

	private static void bfs(int r, int c, int l) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(r, c, l));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.row + 1 == row && node.col + 1 == col) {
				System.out.println(node.length);
				break; // end
			}
			
			matrix[node.row][node.col] = 0;
			
			// 우로이동
			if (node.col + 1 < col && matrix[node.row][node.col + 1] == 1) {
				queue.add(new Node(node.row, node.col + 1, node.length + 1));
			}

			// 아래로이동
			if (node.row + 1 < row && matrix[node.row + 1][node.col] == 1) {
				queue.add(new Node(node.row + 1, node.col, node.length + 1));
			}

			// 위로이동
			if (node.row - 1 >= 0 && matrix[node.row - 1][node.col] == 1) {
				queue.add(new Node(node.row - 1, node.col, node.length + 1));
			}

			// 좌로이동
			if (node.col - 1 >= 0 && matrix[node.row][node.col - 1] == 1) {
				queue.add(new Node(node.row, node.col - 1, node.length + 1));
			}

		}
	}
}

class Node {
	int row;
	int col;
	int length;

	public Node(int row, int col, int length) {
		this.row = row;
		this.col = col;
		this.length = length;
	}
}
