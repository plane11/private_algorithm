package koitp.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Jewelry {

	// done
	static int N, K;
	static JVO[] J;// jewelry
	static int[] B;// bag

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());

		J = new JVO[N + 1];

		for (int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());
			J[n] = new JVO(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}

		Arrays.sort(J, 1, N + 1);

		B = new int[K + 1];
		for (int k = 1; k <= K; k++) {
			B[k] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(B, 1, K + 1);

		long sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int jIndex = 1;
		for (int b = 1; b <= K; b++) {
			while (jIndex <= N && J[jIndex].w <= B[b]) {
				pq.add(-J[jIndex].p);
				jIndex++;
			}
			
			if(!pq.isEmpty()) {
				sum+= -pq.poll();
			}

		}

		System.out.println(sum);
	}
}

class JVO implements Comparable<JVO> {
	int w;
	int p;

	public JVO(int w, int p) {
		this.w = w;
		this.p = p;
	}

	@Override
	public int compareTo(JVO o) {
		return w - o.w;
	}

	@Override
	public String toString() {
		return "JVO [w=" + w + ", p=" + p + "]";
	}

}