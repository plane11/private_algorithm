package koitp.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PresentiveValue {

	static int N, Q;
	static long[] D;

	static InnerValue[] V;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());

		int treeSize = (int) Math.pow(2, Integer.toBinaryString(N).length() + 1);
		int leafSize = treeSize / 2;

		D = new long[treeSize];
		V = new InnerValue[treeSize];

		token = new StringTokenizer(br.readLine());
		for (int n = 1; n <= leafSize; n++) {
			int v = 0;
			if (n <= N) {
				D[leafSize + n - 1] = Long.parseLong(token.nextToken());
				V[leafSize + n - 1] = new InnerValue(v, v, v);
			} else {
				V[leafSize + n - 1] = new InnerValue(0, 0, 0);
			}

			V[n] = new InnerValue(0, 0, 0);
		}

		for (int i = leafSize - 1; i > 0; i--) {
			long min = Math.min(V[i * 2].min, V[i * 2 + 1].min);
			long max = Math.max(V[i * 2].max, V[i * 2 + 1].max);
			long sum = V[i * 2].sum + V[i * 2 + 1].sum;

			V[i] = new InnerValue(min, max, sum);
		}

		Q = Integer.parseInt(br.readLine());
		for (int q = 1; q <= Q; q++) {
			token = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(token.nextToken());
			int rear = Integer.parseInt(token.nextToken());

			long min = (long) 2e20;
			long max = (long) -2e20;
			long sum = 0;

			while (front >= rear) {
				if (front == rear) {
					break;
				}

				if (front % 2 == 1) {
					min = Math.min(V[front].min, min);
					max = Math.max(V[front].max, max);
					sum = V[front].sum + sum;

					front++;
				}

				if (rear % 2 == 0) {
					min = Math.min(V[front].min, min);
					max = Math.max(V[front].max, max);
					sum = V[front].sum + sum;

					rear--;
				}

				front /= 2;
				rear /= 2;
			}

			System.out.println(min + " " + max + " " + sum);
		}

	}

}

class InnerValue {
	long min;
	long max;
	long sum;

	public InnerValue(long min, long max, long sum) {
		this.min = min;
		this.max = max;
		this.sum = sum;
	}
}