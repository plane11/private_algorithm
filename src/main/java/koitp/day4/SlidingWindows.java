package koitp.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SlidingWindows {

	static int N, K;

	static int[] sum;
	static Deque<Value> min;
	static Deque<Value> max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());

		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());

		sum = new int[N + 1];
		min = new LinkedList<>();
		max = new LinkedList<>();

		token = new StringTokenizer(br.readLine());

		for (int n = 1; n <= N; n++) {
			int v = Integer.parseInt(token.nextToken());

			// sum
			sum[n] += v;
			if (n > K) {
				sum[n] -= sum[n - K];
			}

			if (n == 1) {
				min.addLast(new Value(n, v));
				max.addLast(new Value(n, v));
			} else {
				// min
				while (!min.isEmpty() && min.getLast().value >= v) {
					min.pollLast();
				}

				min.addLast(new Value(n, v));
				if (min.getFirst().index < n - K) {
					min.pollFirst();
				}

				// max
				while (!max.isEmpty() && max.getLast().value <= v) {
					max.pollLast();
				}

				max.addLast(new Value(n, v));
				if (max.getFirst().index < n - K) {
					max.pollFirst();
				}
			}

			if (n >= K)
				System.out.println(sum[n] + " " + min.getFirst().value + " " + max.getFirst().value);
		}
	}
}

class Value {
	int index;
	int value;

	public Value(int index, int value) {
		this.index = index;
		this.value = value;
	}
}