package koitp.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Picnic {

	static int K, N, M;

	static int[] C;
	static int[][] matrix;
	static int[][] result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		K = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		C = new int[K + 1];
		matrix = new int[N + 1][N + 1];
		result = new int[K + 1][N + 1];

		for (int k = 1; k <= K; k++) {
			C[k] = Integer.parseInt(br.readLine());
		}

		for (int m = 1; m <= M; m++) {
			token = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());

			matrix[a][b] = 1;
		}

		for (int k = 1; k <= K; k++) {
			dfs(k, C[k]);
		}

		int ans = -1;
		for (int i = 1; i <= N; i++) {
			boolean isSame = true;
			for (int k = 1; k <= K; k++) {
				if (k > 1) {
					isSame = result[k - 1][i] == result[k][i];

					if (!isSame) {
						break;
					}
				}
			}

			if (isSame) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int k, int i) {
		result[k][i] = 1;

		for (int n = 1; n <= N; n++) {
			if (result[k][n] == 0 && matrix[i][n] == 1) {
				dfs(k, n);
			}
		}
		return;
	}

}
