package baekjoon.S1003;

import java.util.Scanner;

public class Main {

	private static int countZero = 0;
	private static int countOne = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		for(int i=0; i<N; i++){
			countZero = 0;
			countOne = 0;
			
			int num = scanner.nextInt();
			fibonacci(num);
			System.out.println(countZero + " " + countOne);
		}
	}

	private static int fibonacci(int n) {
		if (n == 0) {
			countZero++;
			return 0;
		} else if (n == 1) {
			countOne++;
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
