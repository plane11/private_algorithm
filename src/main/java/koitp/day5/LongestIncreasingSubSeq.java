package koitp.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class LongestIncreasingSubSeq {

	static int N;

	static List<Integer> V = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int v = Integer.parseInt(token.nextToken());

			if (n == 0) {
				V.add(v);
			} else {
				binarySearch(v);
			}
		}

		System.out.println(V.size());
	}

	private static void binarySearch(int v) {
		int front = 0;
		int rear = V.size() - 1;

		// TODO binary search ÇØ¼­ index replace or append
		while (front <= rear) {
			int middle = (front + rear) / 2;

			if (middle == 0) {
				if(v != V.get(middle)) {
					V.add(v);
				}
				break;
			} else {
				if(V.get(middle) == v || V.get(middle + 1) == v) {
					break;
				}else{
					if (V.get(middle) < v && V.get(middle + 1) < v) {
						V.set(middle, v);
						break;
					} else if (v < V.get(middle)) {
						rear = middle;
					} else {
						front = middle;
					}
				}
			}
		}

	}
}
