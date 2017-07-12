package koitp.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologicalSort {

	// done
	static int V, E;
	static Queue<Integer> queue;
	static ArrayList<Integer> order;
	static int[] in;
	static ArrayList<Integer>[] con;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		queue = new LinkedList<>();
		order = new ArrayList<>();

		con = new ArrayList[V + 1];
		in = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			con[i] = new ArrayList<>();
		}

		int a, b;
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			con[a].add(b);
			in[b]++;
		}

		for (int i = 1; i <= V; i++) {
			if (in[i] == 0)
				queue.add(i);

		}

		while (!queue.isEmpty()) {
			int q = queue.poll();
			order.add(q);
			System.out.print(q + " ");
			for (int t : con[q]) {
				if (--in[t] == 0) {
					queue.add(t);
				}
			}
		}
	}
}
