package koitp.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrimeNumberPath {
  //done
	static int T;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int s, e;
		boolean[] isPrime = new boolean[10000];
		int[] dist = new int[10000];
		int[] base = { 1000, 100, 10, 1 };

		// 소수 판별
		for (int i = 1001; i < 10000; i += 2) {
			isPrime[i] = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					isPrime[i] = false;
					break;
				}
			}
		}

		for (int t = 1; t < T + 1; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			for (int i = 1000; i < 10000; i++) {
				dist[i] = -1;
			}

			for (int i = 1000; i < 10000; i++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(s);
				dist[s] = 0;
				while (!queue.isEmpty()) {
					int n = queue.poll();
					for (int j = 0; j < 4; j++) {
						for (int k = 0; k < 10; k++) {
							int v = (n / base[j] / 10 * 10 * base[j]) + (n % base[j]) + k * base[j];
							if (v < 1000 || !isPrime[v] || dist[v] != -1)
								continue;
							dist[v] = dist[n] + 1;
							queue.add(v);
						}
					}
				}
			}

			System.out.println(dist[e]);
		}

	}
}
