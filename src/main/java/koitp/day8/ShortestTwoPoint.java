package koitp.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ShortestTwoPoint {

	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		matrix = new int[N][2];

		StringTokenizer token;
		for (int n = 0; n < N; n++) {
			token = new StringTokenizer(br.readLine());

			matrix[n][0] = Integer.parseInt(token.nextToken());
			matrix[n][1] = Integer.parseInt(token.nextToken());
		}

		int answer = (int) closestDistance(matrix);

		System.out.println(answer);
	}

	private static double closestDistance(int[][] p) {
		if (p == null) {
			return -1;
		}

		int n = p.length;
		if (n == 1)
			return -1;

		// 1. Generate Points with given array: O(n)
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			points[i] = new Point(i, p[i][0], p[i][1]);
		}

		// 2. Sort by x-coordinate: O(nlog(n))
		Point[] xPoints = new Point[n];
		System.arraycopy(points, 0, xPoints, 0, n);
		Arrays.sort(xPoints, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x > p2.x) {
					return 1;
				} else if (p1.x < p2.x) {
					return -1;
				}
				return 0;
			}
		});

		// 3. calculate closest distance: nlog(n)^2
		double d = closest(xPoints, 0, n - 1);

		return d;
	}

	private static double closest(Point[] xPoints, int s, int e) {
		// 1. base
		if ((e - s) == 0) {
			return Double.POSITIVE_INFINITY;
		}

		// 2. divide : log(n)
		int m = (s + e) / 2;

		double d1 = closest(xPoints, s, m);
		double d2 = closest(xPoints, m + 1, e);
		double d = (d1 < d2) ? d1 : d2;

		// 3. merge
		// (m-d) ~ (m+d) 사이 band에 있는 점들 = bPoints
		Point[] bPoints = new Point[e - s + 1];
		Point midPoint = xPoints[m];
		int k = 0;
		for (int i = s; i <= e; i++) {
			if (Math.abs(xPoints[i].x - midPoint.x) <= d) {
				bPoints[k++] = xPoints[i];
			}
		}

		double d3 = closestInBand(bPoints, k, d);

		return d3;
	}

	private static double closestInBand(Point[] bPoints, int size, double minDist) {
		// sort
		Arrays.sort(bPoints, 0, size, new YComparator());

		double d;
		for (int i = 0; i < size; i++) {
			// for(int j=i+1;j<size && j<=(i+6);j++){
			for (int j = i + 1; j < size && ((bPoints[j].y - bPoints[i].y) < minDist); j++) {
				d = dist(bPoints[i], bPoints[j]);
				if (d < minDist) {
					minDist = d;
				}
			}
		}

		return minDist;
	}

	private static double dist(Point a, Point b) {
		return a.dist(b);
	}

}

class Point {
	int idx;
	int x, y;

	public Point(int idx, int x, int y) {
		this.idx = idx;
		this.x = x;
		this.y = y;
	}

	public double dist(Point b) {
		return Math.sqrt(Math.pow((x - b.x), 2) + Math.pow(y - b.y, 2));

	}
}

class YComparator implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		if (p1.y > p2.y) {
			return 1;
		} else if (p1.y < p2.y) {
			return -1;
		}
		return 0;
	}
}