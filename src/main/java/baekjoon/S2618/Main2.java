package baekjoon.S2618;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main2 {

	static int[] flatMatrix;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample.txt"));
		Scanner scanner = new Scanner(System.in);

		int size = scanner.nextInt();
		int N = scanner.nextInt();

		// 경찰차1
		int police1X = 1;
		int police1Y = 1;

		// 경찰차2
		int police2X = size;
		int police2Y = size;

		flatMatrix = new int[N * 2];

		int min = 0;
		for (int i = 0; i < N; i++) {
			int accidentX = scanner.nextInt();
			int accidentY = scanner.nextInt();

			flatMatrix[i] = accidentX;
			flatMatrix[i + 1] = accidentY;
		}

	}

	private static void calc(int p1x, int p1y, int p2x, int p2y) {
		
	}

}
