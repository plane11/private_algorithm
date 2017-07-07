package koitp.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoToWork {

	// done
	static int H, W, N;
	static int[][] matrix;
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());

		H = Integer.parseInt(token.nextToken());
		W = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());

		matrix = new int[H + 2][W + 2];
		visited = new int[H + 2][W + 2];

		for (int h = 1; h <= H; h++) {
			token = new StringTokenizer(br.readLine());
			for (int w = 1; w <= W; w++) {
				matrix[h][w] = Integer.parseInt(token.nextToken());
			}
		}

		visited[1][1] = N - 1;
		for (int h = 1; h <= H; h++) {
			for (int w = 1; w <= W; w++) {
				// TODO ???????
				visited[h][w] += (visited[h - 1][w] + (1 - matrix[h - 1][w])) / 2;
				visited[h][w] += (visited[h][w - 1] + matrix[h][w - 1]) / 2;
			}
		}

		for (int h = 1; h <= H; h++) {
			for (int w = 1; w <= W; w++) {
				if (visited[h][w] % 2 == 1) {
					matrix[h][w] = 1 - matrix[h][w];
				}
			}
		}
		
//		System.out.println("--------------------------------------");
//		for (int h = 1; h <= H; h++) {
//			for (int w = 1; w <= W; w++) {
//				System.out.print(visited[h][w] + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println("--------------------------------------");
//		for (int h = 1; h <= H; h++) {
//			for (int w = 1; w <= W; w++) {
//				System.out.print(matrix[h][w] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("--------------------------------------");
		start(1, 1);
	}

	private static void start(int h, int w) {
		if (h > H || w > W) {
			System.out.println(h + " " + w);
		} else {
			if(matrix[h][w] == 1) {
				start(h, w+1);
			}else{
				start(h+1, w);
			}
		}
	}
}
