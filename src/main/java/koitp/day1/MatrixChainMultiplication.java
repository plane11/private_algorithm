package koitp.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixChainMultiplication {

	static int N;
	static int[] P;
	static int[][] minMatrix;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = new int[N + 2];

		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N + 1; i++) {
			P[i] = Integer.parseInt(token.nextToken());
		}

		minMatrix = new int[N + 1][N + 1];

		for (int buf = 0; buf < N; buf++) {
			for (int i = 1; i <= N; i++) {
				if (i + buf <= N) {
					if (buf == 0) {
						minMatrix[i][i + buf] = 0;
					} else {
						minMatrix[i][i + buf] = getMin(i, i + buf);
					}
				}
			}
		}
		
		System.out.println(minMatrix[1][N]);
	}

	private static int getMin(int i, int j) {
		for (int n = i; n <= j; n++) {
			for (int m = n; m <= j; m++) {
				minMatrix[n][m] = Math.min(minMatrix[n][m], P[n] * P[m]); 
			}
		}

		return minMatrix[i][j];
	}

}
