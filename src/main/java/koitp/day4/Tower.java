package koitp.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Tower {
	// done

	static int N;

	static int[] D;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		D = new int[N + 1];

		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			int h = Integer.parseInt(token.nextToken());
			D[n] = h;

			if (n == 1) {
				bw.append(0 + " ");
				continue;
			}

			boolean meet = false;
			for (int m = n - 1; m > 0; m--) {
				if (D[m] - h >= 0) {
					bw.append(m + " ");
					meet = true;
					break;
				}
			}

			if (!meet) {
				bw.append(0 + " ");
			}
		}

		bw.flush();
	}

}
