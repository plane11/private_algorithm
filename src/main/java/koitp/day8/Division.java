package koitp.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Division {

	// done
	static int N;
	static int[][] matrix;

	static int zeroCount = 0;
	static int oneCount = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		matrix = new int[N + 1][N + 1];

		StringTokenizer token;
		for (int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());

			for (int m = 1; m <= N; m++) {
				matrix[n][m] = Integer.parseInt(token.nextToken());
			}
		}

		calc(1, 1, N);

		System.out.println(zeroCount);
		System.out.println(oneCount);
	}

	private static void calc(int i, int j, int size) {
		int sum = 0;
		for (int n = i; n < i + size; n++) {
			for (int m = j; m < j + size; m++) {
				sum += matrix[n][m];
			}
		}

		if (sum == size * size) {
			oneCount++;
		} else if (sum == 0) {
			zeroCount++;
		} else {
			calc(i, j, size / 2);
			calc(i + size / 2, j, size / 2);
			calc(i, j + size / 2, size / 2);
			calc(i + size / 2, j + size / 2, size / 2);
		}
	}
}
