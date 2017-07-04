package koitp.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollerCoaster {
	// done
	static int L, N, B;
	static int[] X, W, F, C;
	static int[][] D;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());

		L = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		B = Integer.parseInt(token.nextToken());

		X = new int[N + 1];
		W = new int[N + 1];
		F = new int[N + 1];
		C = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());

			X[n] = Integer.parseInt(token.nextToken());
			W[n] = Integer.parseInt(token.nextToken());
			F[n] = Integer.parseInt(token.nextToken());
			C[n] = Integer.parseInt(token.nextToken());
		}

		D = new int[L + 1][B + 1];

		for (int i = 0; i <= L; i++) {
			for (int j = 0; j <= B; j++) {
				D[i][j] = -1;
			}
		}

		D[0][0] = 0;

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < B; j++) {
				if (D[i][j] >= 0) {
					for (int k = 1; k <= N; k++) {
						if (X[k] == i && j + C[k] <= B) {
							D[i + W[k]][j + C[k]] = Math.max(D[i + W[k]][j + C[k]], D[i][j] + F[k]);
						}
					}
				}
			}
		}

		int ans = -1;
		for (int i = 0; i <= B; i++) {
			ans = Math.max(ans, D[L][i]);
		}
		System.out.println(ans);

	}

}

class Piece implements Comparable<Piece> {
	int position;
	int length;
	int fun;
	int cost;

	public Piece(int position, int length, int fun, int cost) {
		this.position = position;
		this.length = length;
		this.fun = fun;
		this.cost = cost;
	}

	@Override
	public int compareTo(Piece p) {
		int diff = position - p.position;
		if (diff == 0) {
			return length - p.length;
		}
		return diff;
	}

	@Override
	public String toString() {
		return "Piece [position=" + position + ", length=" + length + ", fun=" + fun + ", cost=" + cost + "]";
	}

}
