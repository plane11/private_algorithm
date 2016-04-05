package baekjoon.S2618;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	// 구역
	static int[][] matrix;
	// 이동차량
	static int[] police;

	// 경찰차1
	static int police1X = 1;
	static int police1Y = 1;
	// 경찰차2
	static int police2X;
	static int police2Y;

	// 동일거리 있을경우
	static boolean branch = false;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample.txt"));
		Scanner scanner = new Scanner(System.in);

		int size = scanner.nextInt();
		int N = scanner.nextInt();

		police = new int[N];

		// 경찰차2
		police2X = size;
		police2Y = size;

		int min = 0;
		for (int i = 0; i < N; i++) {
			int accidentX = scanner.nextInt();
			int accidentY = scanner.nextInt();

			min += go(accidentX, accidentY, i);
		}

		System.out.println(min);
		for (int i = 0; i < N; i++) {
			System.out.println(police[i]);
		}

	}

	private static int go(int accidentX, int accidentY, int index) {

		// 1호출동
		int car1 = findDistance(police1X, police1Y, accidentX, accidentY);
		System.out.println("1호차 > " + car1);

		// 2호출동
		int car2 = findDistance(police2X, police2Y, accidentX, accidentY);
		System.out.println("2호차 > " + car2);
		
		if (car1 > car2) {
			police2X = accidentX;
			police2Y = accidentY;
			police[index] = 2;
			if(branch){
				branch = false;
				police[index - 1] = 2;
				System.out.println("##이전보류 - 2호");
			}
			System.out.println("[2호차 출동] to (" + accidentX + "," + accidentY + ")" );
			return car2;
		} else if (car1 < car2) {
			police1X = accidentX;
			police1Y = accidentY;
			police[index] = 1;
			if(branch){
				branch = false;
				police[index - 1] = 1;
				System.out.println("##이전보류 - 1호");
			}
			System.out.println("[1호차 출동] to (" + accidentX + "," + accidentY + ")" );
			return car1;
		} else {
			System.out.println("[출동보류] to (" + accidentX + "," + accidentY + ")" );
			branch = true;
			return car1;
		}
	}

	private static int findDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
