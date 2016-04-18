package baekjoon.S9663;

import java.util.Scanner;

public class Main {

	static int N;
	static int count;
	static int[] sol = new int[16];
	static int[] col = new int[16];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();

		count = 0;
		backstrack(0);
		System.out.println(count);

	}

	private static void backstrack(int row) {
		if (isSolution(row)) {
			process();
			return;
		}

		loop: for (int i = 0; i < N; i++) {
			if (col[i] == 1) {
				continue loop;
			}

			for (int j = 0; j < row; j++) {
				if (Math.abs(row - j) == Math.abs(i - sol[j])) {
					continue loop;
				}
			}

			sol[row] = i;
			col[i] = 1;
			backstrack(row + 1);
			col[i] = 0;
		}
	}

	private static boolean isSolution(int row) {
		return row == N;
	}

	private static void process() {
		count++;
	}

}
