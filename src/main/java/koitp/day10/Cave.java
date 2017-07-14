package koitp.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cave {

	// done
	static int N, H;
	static int[] B;
	static int[] T;

	static int[] D;

	static int[] B_SUM;
	static int[] T_SUM;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());

		D = new int[H + 1];
		B = new int[H + 1];
		T = new int[H + 1];
		B_SUM = new int[H + 1];
		T_SUM = new int[H + 1];

		int b_max = -1;
		int t_max = -1;
		
		int min = Integer.MAX_VALUE;
		int count = 0;

		for (int n = 1; n <= N / 2; n++) {
			int b = Integer.parseInt(br.readLine());
			int t = Integer.parseInt(br.readLine());

			B[b]++;
			T[t]++;

			b_max = Math.max(b_max, b);
			t_max = Math.max(t_max, t);
		}

		for (int i = b_max; i > 0; i--) {
			B_SUM[i] = B[i] + B_SUM[i + 1];
		}

		for (int i = t_max; i > 0; i--) {
			T_SUM[i] = T[i] + T_SUM[i + 1];
		}

		for (int i = 1; i <= H; i++) {
			if (i == 1) {
				D[i] = B_SUM[1];
			} else if (i == H) {
				D[i] = T_SUM[1];
			} else {
				D[i] = B_SUM[i] + T_SUM[H - i + 1];
			}

			if (D[i] == min) {
				count++;
			} else if (D[i] < min) {
				count = 1;
				min = D[i];
			}
		}
		
		System.out.println(min + " " + count);

	}

}
