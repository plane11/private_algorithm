package koitp.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DownRoad {

	static int MOD = 1234567;

	static int N, M;
	static int[][] matrix;
	static int[][] count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());

		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		matrix = new int[M + 1][N + 1];
		count = new int[M + 1][N + 1];

		for (int m = 1; m <= M; m++) {
			token = new StringTokenizer(br.readLine());

			for (int n = 1; n <= N; n++) {
				matrix[m][n] = Integer.parseInt(token.nextToken());
			}
		}

		count[1][1] = 1;
		dfs(1, 1);
		
		System.out.println(count[M][N]);

	}

	private static void dfs(int i, int j) {
		int point = matrix[i][j];
		
//		System.out.println();
//		System.out.println("visit (" + i + ", " + j + ")");
//		printCount();
		
		// À§
		if (i - 1 > 0 && i - 1 <= M && matrix[i - 1][j] < point) {
			count[i - 1][j] += count[i][j];
			dfs(i - 1, j);
		}

		// ¾Æ·¡
		if (i + 1 > 0 && i + 1 <= M && matrix[i + 1][j] < point) {
			count[i + 1][j] += count[i][j];
			dfs(i + 1, j);
		}

		// ÁÂ
		if (j - 1 > 0 && j - 1 <= N && matrix[i][j - 1] < point) {
			count[i][j - 1] += count[i][j];
			dfs(i, j - 1);
		}

		// ¿ì
		if (j + 1 > 0 && j + 1 <= N && matrix[i][j + 1] < point) {
			count[i][j + 1] += count[i][j];
			dfs(i, j + 1);
		}
		
		return;
	}

	private static void printCount() {
		System.out.println("--------------------------------------------");
		for (int m = 1; m <= M; m++) {
			for (int n = 1; n <= N; n++) {
				System.out.print(count[m][n] + " ");
			}
			System.out.println();
		}
	}
}
