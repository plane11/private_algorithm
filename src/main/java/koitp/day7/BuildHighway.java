package koitp.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BuildHighway {

	// done
	static int N, M;
	static int[] par;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		ArrayList<Edge> edges = new ArrayList<>();

		StringTokenizer st;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges.add(new Edge(from, to, cost));
		}

		Collections.sort(edges, new Comparator<Edge>() {
			public int compare(Edge a, Edge b) {
				return a.cost - b.cost;
			}
		});

		par = new int[N + 1];
		for (int i = 1; i <= N; i++)
			par[i] = i;

		long ans = 0;
		for (Edge e : edges) {
			int a = find(e.from);
			int b = find(e.to);
			if (a == b)
				continue;
			par[b] = a;
			ans += e.cost;
		}
		System.out.println(ans);
	}

	static int find(int n) {
		if (par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}
}

class Edge {
	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	int from, to, cost;
}