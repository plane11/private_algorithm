package koitp.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowParty {

	static int inf = 99999; // 무한대 값

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());

		int N, M, X;
		int[][] weightMatrix;
		int maxDikstra = 0;

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		X = Integer.parseInt(token.nextToken()) - 1;

		weightMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				weightMatrix[i][j] = inf;
			}
		}

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			weightMatrix[Integer.parseInt(token.nextToken()) - 1][Integer.parseInt(token.nextToken()) - 1] = Integer
					.parseInt(token.nextToken());
		}

		int[][] resultDikstra = new int[N][N];
		for (int i = 0; i < N; i++) {
			resultDikstra[i] = dikstra(weightMatrix, i);
		}
//		printGraph(resultDikstra, N);

		for (int i = 0; i < N; i++) {
			if (i == X)
				continue;
			int tempTime = resultDikstra[i][X] + resultDikstra[X][i];
			if (tempTime > maxDikstra)
				maxDikstra = tempTime;
		}
		System.out.println(maxDikstra + "");
	}

	public static int[] dikstra(int[][] graph, int start) {
		int vCount = graph[0].length;
		boolean[] isVisits = new boolean[vCount];
		int[] distance = new int[vCount];

		int nextVertex = start;
		int min = 0;

		for (int i = 0; i < vCount; i++) {
			isVisits[i] = false;
			distance[i] = inf;

		}
		distance[start] = 0;

		// 다익스트라 실행
		while (true) {
			min = inf;
			for (int j = 0; j < vCount; j++) {
				if (isVisits[j] == false && distance[j] < min) {
					nextVertex = j;
					min = distance[j];
				}
			}
			if (min == inf)
				break;
			isVisits[nextVertex] = true;

			for (int j = 0; j < vCount; j++) {
				int distanceVertex = distance[nextVertex] + graph[nextVertex][j];
				if (distance[j] > distanceVertex) {
					distance[j] = distanceVertex;
				}
			}
		}
		return distance;
	}

	public static void printGraph(int[][] graph, int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < count; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
