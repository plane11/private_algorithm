package baekjoon.S1992;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < N; j++) {
				matrix[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}

		String result = count(N, 0, 0);
//		if(result.length() == 1){
//			result = "(" + result + ")";
//		}
		System.out.println(result);
	}

	private static String count(int size, int startRow, int startCol) {
		if (size > 1) {
			String result1 = count(size / 2, startRow, startCol);
			String result2 = count(size / 2, startRow, startCol + size / 2);
			String result3 = count(size / 2, startRow + size / 2, startCol);
			String result4 = count(size / 2, startRow + size / 2, startCol + size / 2);

			// System.out.println("(" + startRow + ", " + startCol + ") /w " +
			// size + " =========================");
			if (isSame(result1, result2, result3, result4)) {
				return result1;
			} else {
				return "(" + result1 + result2 + result3 + result4 + ")";
			}
		} else {
			return matrix[startRow][startCol] + "";
		}
	}

	private static boolean isSame(String str1, String str2, String str3, String str4) {
		// System.out.println("SAME > " + str1 + "-" + str2 + "-" + str3 + "-" +
		// str4);
		return str1.length() == 1 && str1.equals(str2) && str2.equals(str3) && str3.equals(str4);
	}

}
