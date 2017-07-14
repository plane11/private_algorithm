package koitp.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class ConvexHull {

	// done
	static int N;
	static HullPoint[] D;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		D = new HullPoint[N + 1];

		StringTokenizer token;
		for (int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			D[n] = new HullPoint(x, y);
		}

		for (int n = 2; n <= N; n++) {
			if (D[1].y > D[n].y || D[1].y == D[n].y && D[1].x > D[n].x) {
				HullPoint tmp = D[1];
				D[1] = D[n];
				D[n] = tmp;
			}
		}

		Arrays.sort(D, 2, N + 1, new Comparator<HullPoint>() {
			public int compare(HullPoint a, HullPoint b) {
				int k = ccw(D[1], a, b);
				if (k != 0)
					return -k;
				return (a.y + Math.abs(a.x - D[1].x)) - (b.y + Math.abs(b.x - D[1].x));
			}
		});

		List<Integer> stack = new ArrayList<>();
		stack.add(1);
		stack.add(2);
		for (int i = 3; i <= N; i++) {
			while (stack.size() > 1) {
				int a = stack.get(stack.size() - 2);
				int b = stack.get(stack.size() - 1);
				if (ccw(D[a], D[b], D[i]) <= 0)
					stack.remove(stack.size() - 1);
				else
					break;
			}
			stack.add(i);
		}
		System.out.println(stack.size());

	}

	static int ccw(HullPoint a, HullPoint b, HullPoint c) {
		return ccw(a.x, a.y, b.x, b.y, c.x, c.y);
	}

	static int ccw(int ax, int ay, int bx, int by, int cx, int cy) {
		long k = (long) (bx - ax) * (cy - ay) - (long) (cx - ax) * (by - ay);
		if (k > 0)
			return 1;
		if (k < 0)
			return -1;
		return 0;
	}
}

class HullPoint {
	int x;
	int y;

	public HullPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

}