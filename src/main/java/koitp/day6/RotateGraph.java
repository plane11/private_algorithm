package koitp.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotateGraph {

	// done
	static int V, E, S;
	static int[][] matrix;
	static int[] visited;
	static int[] queue;
	static int qFront = 0, qRear = 0;

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		V = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());

		matrix = new int[V + 1][V + 1];

		for (int e = 0; e < E; e++) {
			token = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(token.nextToken());
			int n2 = Integer.parseInt(token.nextToken());

			matrix[n1][n2] = 1;
			matrix[n2][n1] = 1;
		}

		calcDfs();
		calcBfs();
	}

	private static void calcDfs() {
		visited = new int[V + 1];
		sb.append(S + " ");
		visited[S] = 1;
		dfs(S);
		System.out.println(sb.toString().trim());
	}

	private static void dfs(int position) {
		for (int i = 1; i <= V; i++) {
			int val = matrix[position][i];
			if (val > 0 && visited[i] < 1) {
				sb.append(i + " ");
				visited[i] = 1;
				dfs(i);
			}
		}
		return;
	}

	private static void calcBfs() {
		sb = new StringBuffer();
		visited = new int[V + 1];
		queue = new int[V + 1];
		queue[++qRear] = S;
		visited[S] = 1;
		sb.append(S + " ");

		bfs();
		System.out.println(sb.toString().trim());
	}

	private static void bfs() {
		while (qFront < qRear) {
			int val = queue[++qFront];

			for (int i = 1; i <= V; i++) {
				int n = matrix[val][i];
				if (n > 0 && visited[i] < 1) {
					queue[++qRear] = i;
					visited[i] = 1;
					sb.append(i + " ");
				}
			}
		}
	}

}
