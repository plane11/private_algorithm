package koitp.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class NQueen_SlashWay {
	// done
	static int N;
	static int ans;

	static boolean col[];
	static boolean slash[];
	static boolean reverseSlash[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		col = new boolean[N];
		slash = new boolean[N + N - 1];
		reverseSlash = new boolean[N + N - 1];

		dfs(0);

		System.out.println(ans);
	}

	private static void dfs(int y) {
		if (y == N) {
			ans++;
			return;
		}

		for (int x = 0; x < N; x++) {
			if (col[x] || slash[y + x] || reverseSlash[y - x + N - 1]) {
				continue;
			} else {
				col[x] = slash[y + x] = reverseSlash[y - x + N - 1] = true;
				dfs(y + 1);
				col[x] = slash[y + x] = reverseSlash[y - x + N - 1] = false;

			}
		}

	}

}
