package koitp.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostNumber {
	// done
	static int N;

	static int[] D;

	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		D = new int[N];

		for (int n = 0; n < N; n++) {
			int v = Integer.parseInt(br.readLine());
			D[n] = v;
		}

		Arrays.sort(D);

		// init -> n = 0
		int maxValue = D[0];
		int maxCount = 1;

		int count = 1;
		int prevValue = D[0];

		for (int n = 1; n < N; n++) {
			int v = D[n];

			if (v == prevValue) {
				count++;
			} else {
				if (count > maxCount) {
					maxCount = count;
					maxValue = prevValue;
				} else if (count == maxCount) {
					maxValue = Math.min(maxValue, v);
				}

				count = 1;
			}

			prevValue = v;
		}

		if (count > maxCount) {
			maxValue = prevValue;
		} else if (count == maxCount) {
			maxValue = Math.min(maxValue, prevValue);
		}

		System.out.println(maxValue);
	}

}
