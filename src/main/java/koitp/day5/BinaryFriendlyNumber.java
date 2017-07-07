package koitp.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BinaryFriendlyNumber {

	// done
	static int N;
	static long[] cache = new long[91];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		if (N < 3) {
			System.out.println(1);
		} else {
			cache[0] = 0;
			cache[1] = 1;
			cache[2] = 2;
			
			calc(3);
			
			System.out.println(cache[N-1]);
		}
	}

	private static void calc(int n) {
		while (n <= N) {
			cache[n] = cache[n - 1] + cache[n - 2];
			n++;
		}

	}
}
