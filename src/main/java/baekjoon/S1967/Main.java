package baekjoon.S1967;

import java.util.Scanner;

public class Main {

	static int node;
	static int[][] matrix;
	static int maxStartNode;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		node = sc.nextInt();
		matrix = new int[node][node];

		for (int i = 0; i < node - 1; i++) {
			int start = sc.nextInt();
			maxStartNode = start > maxStartNode ? start : maxStartNode;
			matrix[start - 1][sc.nextInt() - 1] = sc.nextInt();
		}

		
		
		
		
		
		for (int i = 0; i < maxStartNode; i++) {
			for (int j = 0; j < node; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
