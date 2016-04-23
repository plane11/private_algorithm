package baekjoon.S3047;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] num = new int[3];

		for (int i = 0; i < 3; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);

		String str = sc.next();

		String result = "";
		for (int i = 0; i < 3; i++) {
			int n = Character.getNumericValue(str.charAt(i)) - 10;
			
			result += num[n] + " ";
		}

		System.out.println(result.trim());
	}
}
