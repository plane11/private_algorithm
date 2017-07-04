package koitp.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinExchange {
//done
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());

		int[] coins = new int[N + 1];

		token = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			coins[n] = Integer.parseInt(token.nextToken());
		}

		Arrays.sort(coins);

		int W = Integer.parseInt(br.readLine());
		int[] dp = new int[W + 1];

		// init
		dp[0] = 0;
		for (int i = 1; i <= W; i++) {
			dp[i] = (int)2e9;
		}

		for (int n = 1; n <= N; n++) {
			for (int i = coins[n]; i <= W; i++) {
				dp[i] = Math.min(dp[i], dp[i - coins[n]] + 1);
			}
		}

		System.out.println(dp[W]);
	}
}
