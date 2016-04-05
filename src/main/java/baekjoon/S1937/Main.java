package baekjoon.S1937;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static int day = 0;
	static int[][] matrix;
	static int N;
	static int[] flatMatrix;

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("sample.txt"));
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		matrix = new int[N][N];
		flatMatrix = new int[N * N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int value = scanner.nextInt();
				matrix[i][j] = value;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				System.out.println("########################################");
//				System.out.println("(" + i + ", " + j + ") = " + matrix[i][j]);
				int min = search(i, j, 1);
				flatMatrix[i + j] = min;
//				System.out.println(i + j + " > " + min);
			}
		}
		System.out.println(day);
	}

	private static int search(int row, int col, int min) {

		if (flatMatrix[row + col] > 0) {
//			System.out.println("@@@ REUSE > " + row + col);
			day = flatMatrix[row + col];
			return day;
		}

		// 좌
		if (col - 1 > -1 && matrix[row][col] < matrix[row][col - 1]) {
//			System.out.println("좌(" + matrix[row][col] + " -> " + matrix[row][col - 1] + ") =>" + (min + 1));
			search(row, col - 1, min + 1);
		}

		// 우
		if (col + 1 < N && matrix[row][col] < matrix[row][col + 1]) {
//			System.out.println("우(" + matrix[row][col] + " -> " + matrix[row][col + 1] + ") =>" + (min + 1));
			search(row, col + 1, min + 1);
		}

		// 상
		if (row - 1 > -1 && matrix[row][col] < matrix[row - 1][col]) {
//			System.out.println("상(" + matrix[row][col] + " -> " + matrix[row - 1][col] + ") =>" + (min + 1));
			search(row - 1, col, min + 1);
		}

		// 하
		if (row + 1 < N && matrix[row][col] < matrix[row + 1][col]) {
//			System.out.println("하(" + matrix[row][col] + " -> " + matrix[row + 1][col] + ") =>" + (min + 1));
			search(row + 1, col, min + 1);
		}

		if (min > 0 && day < min) {
			day = min;
		}
		return min == 1 ? 0 : min;
	}

}
