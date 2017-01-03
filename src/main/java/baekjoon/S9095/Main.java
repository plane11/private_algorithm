package baekjoon.S9095;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample.txt"));

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int i = 1; i <= T; i++) {

			int[] array = new int[11];
			int num = scanner.nextInt();

			for (int n = 1; n <= num; n++) {
				if (n == 1) {
					array[n] = 1;
				} else if (n == 2) {
					array[n] = 2;
				} else if (n == 3) {
					array[n] = 4;
				} else {
					array[n] = array[n - 1] + array[n - 2] + array[n - 3];
				}
			}

			System.out.println(array[num]);
		}
	}
}
