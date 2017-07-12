package koitp.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GhostShip {

	// done
	static int W, H;
	static char[][] matrix;

	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		W = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());

		matrix = new char[H + 1][W + 1];
		visit = new boolean[H + 1][W + 1];

		String line;
		Node node = null;
		for (int i = 1; i <= H; i++) {
			line = br.readLine();
			for (int j = 1; j <= W; j++) {
				matrix[i][j] = line.charAt(j - 1);
				visit[i][j] = false;

				if (matrix[i][j] == 'S') {
					node = new Node(i, j, 1);
					visit[i][j] = true;
				}
			}
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		boolean isExit = false;
		int count = 0;
		while (!queue.isEmpty()) {
			Node n = queue.poll();

//			System.out.println("Visit (" + n.row + ", " + n.col + ")");

			if (matrix[n.row][n.col] == 'E') {
				count = n.count - 1;
				isExit = true;
				break;
			}

			// down
			if (n.row + 1 > 0 && n.row + 1 <= H && matrix[n.row + 1][n.col] != 'X' && !visit[n.row + 1][n.col]) {
				queue.add(new Node(n.row + 1, n.col, n.count + 1));
				visit[n.row + 1][n.col] = true;
			}

			// up
			if (n.row - 1 > 0 && n.row - 1 <= H && matrix[n.row - 1][n.col] != 'X' && !visit[n.row - 1][n.col]) {
				queue.add(new Node(n.row - 1, n.col, n.count + 1));
				visit[n.row - 1][n.col] = true;
			}

			// left
			if (n.col - 1 <= W && n.col - 1 > 0 && matrix[n.row][n.col - 1] != 'X' && !visit[n.row][n.col - 1]) {
				queue.add(new Node(n.row, n.col - 1, n.count + 1));
				visit[n.row][n.col - 1] = true;
			}

			// right
			if (n.col + 1 > 0 && n.col + 1 <= W && matrix[n.row][n.col + 1] != 'X' && !visit[n.row][n.col + 1]) {
				queue.add(new Node(n.row, n.col + 1, n.count + 1));
				visit[n.row][n.col + 1] = true;
			}
		}

		if (isExit) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}
}

class Node {
	int row;
	int col;
	int count;

	public Node(int row, int col, int count) {
		this.row = row;
		this.col = col;
		this.count = count;
	}

}