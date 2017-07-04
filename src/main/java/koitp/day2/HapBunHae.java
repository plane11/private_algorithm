package koitp.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HapBunHae {
	// done
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());

		int[][] matrix = new int[K + 1][N + 1];

		for (int n = 0; n <= N; n++) {
			matrix[1][n] = 1;
		}

		for (int i = 1; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				for (int l = 0; l <= j; l++) {
					matrix[i][j] += matrix[i - 1][j - l];
					matrix[i][j] %= 1000000000;
				}
			}
		}

		System.out.println(matrix[K][N]);
	}
}
