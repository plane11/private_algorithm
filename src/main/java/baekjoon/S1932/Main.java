package baekjoon.S1932;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int height = Integer.parseInt(line);

		int[][] matrix = new int[height + 1][height + 1];
		for (int i = 0; i <= height; i++) {
			Arrays.fill(matrix[i], 0);
		}

		for (int i = 1; i <= height; i++) {
			line = br.readLine();

			StringTokenizer tokenizer = new StringTokenizer(line, " ");
			int count = tokenizer.countTokens();

			for (int n = 1; n <= count; n++) {
				int num = Integer.parseInt(tokenizer.nextToken());

				// 기존에 갖고 있던 값
				int original = matrix[i][n];
				
				// 바로위칸
				int prev = matrix[i-1][n];
				matrix[i][n] = Math.max(original, prev + num);
				
				// 1 이상이면 위-좌측 값과도 비교
				if(n > 1) {
					original = matrix[i][n];
					prev = matrix[i-1][n-1];
					matrix[i][n] = Math.max(original, prev + num);
				}
				
//				printMatrix(matrix);
			}

		}

		int result = 0;
		for (int i = 1; i <= height; i++) {
			result = Math.max(result, matrix[height][i]);
		}

		System.out.println(result);

	}

	private static void printMatrix(int[][] matrix) {
		System.out.println("--------------------------------------");
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
