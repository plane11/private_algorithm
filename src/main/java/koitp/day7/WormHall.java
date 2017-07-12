package koitp.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WormHall {

	// done
	
	static int T, N, M, W;
	static int[] dist;
	static List<Hall> list;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());

			dist = new int[N + 1];
			list = new ArrayList<>();

			for (int m = 1; m <= M; m++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				int c = Integer.parseInt(token.nextToken());

				list.add(new Hall(a, b, c));
				list.add(new Hall(b, a, c));
			}

			for (int w = 1; w <= W; w++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				int c = Integer.parseInt(token.nextToken());
				list.add(new Hall(a, b, -c));
			}

			boolean exit = false;
			for (int n = 1; n <= N; n++) {
				boolean sw = false;
				for (Hall h : list) {
					if (dist[h.b] > dist[h.a] + h.c) {
						dist[h.b] = dist[h.a] + h.c;
						sw = true;
					}
				}

				if (!sw) {
					exit = true;
					break;
				}
			}
			
			System.out.println(exit ? "NO" : "YES");
		}
	}
}

class Hall {
	int a, b, c;

	public Hall(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

}