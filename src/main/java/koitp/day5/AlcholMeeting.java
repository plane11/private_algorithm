package koitp.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AlcholMeeting {

	// done
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Point[] point = new Point[N];

		StringTokenizer token;
		for (int n = 0; n < N; n++) {
			token = new StringTokenizer(br.readLine());
			point[n] = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}

		Arrays.sort(point);

		// init
		long time = point[0].dist * 2;
		long appendBottle = 0;

		for (int n = 1; n < N; n++) {
			appendBottle += time * point[n].bottle;
			time += point[n].dist * 2;
		}

		System.out.println(appendBottle);
	}
}

class Point implements Comparable<Point> {
	int dist;
	int bottle;

	public Point(int dist, int bottle) {
		this.dist = dist;
		this.bottle = bottle;
	}

	@Override
	public int compareTo(Point o) {
		return dist * o.bottle - o.dist * bottle;
	}
}
