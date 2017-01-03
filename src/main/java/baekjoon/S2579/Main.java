package baekjoon.S2579;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample.txt"));

		Scanner scanner = new Scanner(System.in);
		int step = scanner.nextInt();

		long[] array = new long[step + 1];
		int[] steps = new int[step + 1];
		array[0] = 0;
		steps[0] = 0;

		for (int i = 1; i <= step; i++) {
			int n = scanner.nextInt();

			steps[i] = n;

			if (i == 1) {
				array[1] = steps[i];
			} else if (i == 2) {
				long a = array[i - 1] + steps[i];
				long b = steps[i];

				array[2] = Math.max(a, b);
			} else {
				long a = array[i - 2] + steps[i];
				long b = array[i - 3] + steps[i - 1] + steps[i];

				array[i] = Math.max(a, b);
			}
		}

		System.out.println(array[step]);
	}
}
