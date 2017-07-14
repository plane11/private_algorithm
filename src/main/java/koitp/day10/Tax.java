package koitp.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Tax {

	static int N, K;
	static long[] dp;

	static PriorityQueue<Long> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());

		dp = new long[N + 1];

		dp[0] = 0;

		token = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			int sales = Integer.parseInt(token.nextToken());

			if (sales + dp[n - 1] > 0) {
				dp[n] = Math.max(sales, dp[n - 1] + sales);
			} else {
				dp[n] = Math.max(sales, 0);
			}
			
			pq.add(dp[n]);
			if (pq.size() > K) {
				pq.poll();
			}
		}

		System.out.println(pq.poll());

	}
}
