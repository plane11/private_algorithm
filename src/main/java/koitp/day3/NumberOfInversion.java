package koitp.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfInversion {

	static int N;
	static int[] D;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		D = new int[N];

		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			D[n] = Integer.parseInt(token.nextToken());
		}

		int count = 0;
		for (int n = 0; n < N; n++) {
			for (int i = n + 1; i < N; i++) {
				if (D[n] > D[i]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
