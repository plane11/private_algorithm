package baekjoon.S1149;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	private static int N;

	private static int[][] matrix;
	private static int[][] weight;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample.txt"));

		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		matrix = new int[N][3];
		weight = new int[N][3];

		for (int i = 0; i < N; i++) {
			matrix[i][0] = scanner.nextInt(); // R
			matrix[i][1] = scanner.nextInt(); // G
			matrix[i][2] = scanner.nextInt(); // B
		}

		weight[0][0] = matrix[0][0];
		weight[0][1] = matrix[0][1];
		weight[0][2] = matrix[0][2];

//		System.out.println(0 + " >> [" + weight[0][0] + ", " + weight[0][1] + ", " + weight[0][2] + "]");
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				int a = matrix[i][j] + weight[i-1][(j + 1) % 3];
				int b = matrix[i][j] + weight[i-1][(j + 2) % 3];
				
				weight[i][j] = Math.min(a, b);
			}

//			System.out.println(i + " >> [" + weight[i][0] + ", " + weight[i][1] + ", " + weight[i][2] + "]");
		}

		int min = weight[N - 1][0];
		for (int i = 1; i < 3; i++) {
			min = Math.min(min, weight[N - 1][i]);
		}

		System.out.println(min);
	}

}
