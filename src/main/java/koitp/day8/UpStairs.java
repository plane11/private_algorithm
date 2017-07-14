package koitp.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class UpStairs {

	static int N;
	static int INF = 1000000007;
	static int[][] matrix = { { 1, 1 }, { 1, 0 } };
	static int[][] base = { { 1, 1 }, { 1, 0 } };
	static int[][] ans = { { 1, 1 }, { 1, 0 } };

	static long[] D;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		makeMatrix(N);

		System.out.println((ans[1][0] + ans[1][1]) % INF);
	}

	private static void makeMatrix(int n) {

		int additionalCount = 0;

		while (n > 1) {
			matrix = multi(matrix, matrix);

			if (n % 2 == 1) {
				additionalCount++;
			}

			n /= 2;
		}

		if (additionalCount > 0) {
			ans = multi(base, matrix);
		} else {
			ans = matrix;
		}
	}

	private static int[][] multi(int[][] m1, int[][] m2) {
		int[][] result = new int[2][2];

		result[0][0] = m1[0][0] * m2[0][0] % INF + m1[0][1] * m2[1][0] % INF;
		result[0][1] = m1[0][0] * m2[0][1] % INF + m1[0][1] * m2[1][1] % INF;
		result[1][0] = m1[1][0] * m2[0][0] % INF + m1[1][1] * m2[1][0] % INF;
		result[1][1] = m1[1][0] * m2[0][1] % INF + m1[1][1] * m2[1][1] % INF;

		return result;
	}

}
