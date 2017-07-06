package koitp.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongmaeng {

	// done
	static int N, Q;

	static int[] group;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Q = Integer.parseInt(br.readLine());

		group = new int[N + 1];

		for (int n = 1; n < N; n++) {
			group[n] = n;
		}

		for (int q = 1; q <= Q; q++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			switch (token.nextToken()) {
			case "0":
				define(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
				break;
			case "1":
				System.out.println(question(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
				break;
			}

		}
	}

	private static void define(int n1, int n2) {
		int root1 = find(group[n1]);
		int root2 = find(group[n2]);

		if (root1 == root2) {
			return;
		}

		group[root2] = root1;
	}

	private static int find(int n) {
		if (n == group[n]) {
			return n;
		} else {
			group[n] = find(group[n]);
			return group[n];
		}
	}

	private static String question(int n1, int n2) {
		return find(n1) == find(n2) ? "1" : "0";
	}
}
