package koitp.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MiddleValue {
	// done
	static int N, M;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> bigger = new PriorityQueue<>();
		PriorityQueue<Integer> smaller = new PriorityQueue(1, Collections.reverseOrder());

		for (int n = 1; n <= N; n++) {
			int value = Integer.parseInt(br.readLine().trim());

			if (n == 1) {
				M = value;
			} else {
				if (value < M) {
					smaller.add(value);
				} else {
					bigger.add(value);
				}
			}

			if (n % 2 == 1) {
				int diff = (smaller.size() - bigger.size()) / 2;

				if (diff == 0) {
				} else if (diff > 0) {
					bigger.add(M);

					for (int i = 1; i < diff; i++) {
						bigger.add(smaller.poll());
					}

					M = smaller.poll();
				} else {
					smaller.add(M);

					for (int i = 1; i < diff * -1; i++) {
						smaller.add(bigger.poll());
					}

					M = bigger.poll();
				}

				System.out.println(M);
			}
		}
	}
}
