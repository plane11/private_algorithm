package baekjoon.S1009;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample.txt"));

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();

			int num = 1;
			
			for (int j = 0; j < b; j++) {
//				System.out.println(num + " --> " + num * a % 10);
				num = num * a % 10;
			}

			System.out.println(num % 10 == 0 ? 10 : num%10);

		}
	}
}
