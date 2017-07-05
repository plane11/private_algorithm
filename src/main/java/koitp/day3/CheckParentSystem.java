package koitp.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CheckParentSystem {

	// done
	static int N, R, Q, k;

	static List<Integer>[] list;
	static int[] start, end;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		R = Integer.parseInt(token.nextToken());
		Q = Integer.parseInt(token.nextToken());

		list = new ArrayList[N + 1];
		start = new int[N + 1];
		end = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		token = new StringTokenizer(br.readLine());

		for (int n = 1; n <= N; n++) {
			int p = Integer.parseInt(token.nextToken());
			if (p != n)
				list[p].add(n);
		}

		k = 0;
		dfs(R);

		// for (int i = 1; i <= N; i++) {
		// System.out.println(i + ": " + start[i] + " " + end[i]);
		// }

		for (int q = 0; q < Q; q++) {
			token = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			if (start[x] <= start[y] && end[x] >= start[y]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static void dfs(int i) {
		start[i] = ++k;
		for (int t : list[i]) {
			dfs(t);
		}
		end[i] = k;
	}
}
