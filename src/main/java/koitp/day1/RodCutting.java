package koitp.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class RodCutting {
	//done
	static int N;
	static int[] bar;

	static int[] max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		bar = new int[N + 1];

		max = new int[N + 1];

		String[] strs = br.readLine().split(" ");
		for (int n = 1; n <= N; n++) {
			bar[n] = Integer.parseInt(strs[n - 1]);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				max[i] = Math.max(max[i], bar[j] + max[i - j]);
			}
		}

		System.out.println(max[N]);
	}

}
