package koitp.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PointPosition {

	// done
	static int N;
	static Point[] D;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		D = new Point[N + 1];

		StringTokenizer token;
		for (int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			D[n] = new Point(x, y);
		}

		for (int n = 1; n <= 2; n++) {
			token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			System.out.println((check(x, y) ? "in" : "out"));
		}
	}

	static boolean check(int x1, int y1) {
		int x2 = (int) 1e9 + 1, y2 = y1 + 1;
		boolean ret = false;
		for (int i = 1; i <= N; i++) {
			int j = i % N + 1;
			if (is_cross(x1, y1, x2, y2, D[i].x, D[i].y, D[j].x, D[j].y))
				ret ^= true;
		}
		return ret;
	}

	static int ccw(int ax, int ay, int bx, int by, int cx, int cy) {
		long k = (long) (bx - ax) * (cy - ay) - (long) (cx - ax) * (by - ay);
		if (k > 0)
			return 1;
		if (k < 0)
			return -1;
		return 0;
	}

	static boolean is_cross(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
		return ccw(ax, ay, bx, by, cx, cy) * ccw(ax, ay, bx, by, dx, dy) < 0
				&& ccw(cx, cy, dx, dy, ax, ay) * ccw(cx, cy, dx, dy, bx, by) < 0;
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}