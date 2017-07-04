package koitp.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetUserPaper {
	// done
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] matrix = new int[N + 1][N + 1];
		int[][] stack = new int[N + 1][N + 1];

		stack[1][0] = 0;

		for (int n = 1; n <= N; n++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			for (int m = 1; m <= N; m++) {
				matrix[n][m] = Integer.parseInt(token.nextToken());

				if (n == 1) {
					stack[n][m] = matrix[n][m] + stack[n][m - 1];
				} else {
					stack[n][m] = Math.max(matrix[n][m] + stack[n][m - 1], matrix[n][m] + stack[n - 1][m]);
				}

			}
		}

		System.out.println(stack[N][N]);

	}

}
