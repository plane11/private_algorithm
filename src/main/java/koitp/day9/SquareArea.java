package koitp.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareArea {

	// done
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] X = new int[N + 1];
		int[] Y = new int[N + 1];

		StringTokenizer token;
		for (int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());
			X[n] = Integer.parseInt(token.nextToken());
			Y[n] = Integer.parseInt(token.nextToken());
		}

		long ans = 0;
		for (int n = 1; n <= N; n++) {
			int m = n % N + 1;
			ans += (long) X[n] * Y[m] - (long) X[m] * Y[n];
		}

		ans = Math.abs(ans);
		System.out.printf("%d.%d\n", ans / 2, ans % 2 == 0 ? 0 : 5);

	}
}
