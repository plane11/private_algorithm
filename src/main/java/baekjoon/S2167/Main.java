package baekjoon.S2167;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample.txt"));

		Scanner scanner = new Scanner(System.in);

		int row = scanner.nextInt();
		int col = scanner.nextInt();

		int[][] matrix = new int[row + 1][col + 1];

		for (int r = 1; r <= row; r++) {
			for (int c = 1; c <= col; c++) {
				matrix[r][c] = scanner.nextInt();
			}
		}

		int T = scanner.nextInt();

		for (int t = 0; t < T; t++) {
			int sum = 0;

			int fromR = scanner.nextInt();
			int fromC = scanner.nextInt();
			int toR = scanner.nextInt();
			int toC = scanner.nextInt();
			
			for(int r = fromR; r<=toR; r++) {
				for(int c = fromC; c<=toC; c++) {
					sum += matrix[r][c];
				}
			}
			
			System.out.println(sum);
		}

	}

}
