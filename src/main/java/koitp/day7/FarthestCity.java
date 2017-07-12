package koitp.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FarthestCity {

	// done
	static int N;

	static int[][] matrix;

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

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans = Math.max(ans, matrix[i][j]);
			}
		}
		System.out.println(ans);

	}
}
