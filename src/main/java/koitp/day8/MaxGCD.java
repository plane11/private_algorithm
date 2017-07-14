package koitp.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MaxGCD {

	// done
	static final int MOD = 10000003;

	static int N, M;
	static int[] A;
	static int[][] D;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		D = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
			M = Math.max(M, A[i]);
		}
		D = new int[N + 1][M + 1];
		D[0][0] = 1;
		for (int i = 0; i < N; i++)
			for (int j = 0; j <= M; j++)
				if (D[i][j] > 0) {
					int g = gcd(j, A[i + 1]);
					D[i + 1][g] = (D[i + 1][g] + D[i][j]) % MOD;
					D[i + 1][j] = (D[i + 1][j] + D[i][j]) % MOD;
				}
		System.out.println(D[N][1]);

	}

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
