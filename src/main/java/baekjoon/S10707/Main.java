package baekjoon.S10707;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int xBasic = sc.nextInt();
		int yBasic = sc.nextInt();
		int yBasicMax = sc.nextInt();
		int yAdditional = sc.nextInt();
		int num = sc.nextInt();

		System.out.println(Math.min(getX(xBasic, num), getY(yBasic, yBasicMax, yAdditional, num)));

	}

	private static int getX(int xBasic, int num) {
		return xBasic * num;
	}

	private static int getY(int yBasic, int yBasicMax, int yAdditional, int num) {
		int result = yBasic;
		
		if(yBasicMax < num) {
			result += (num - yBasicMax) * yAdditional;
		}
		
		return result;
	}

}
