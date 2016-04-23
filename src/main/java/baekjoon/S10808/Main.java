package baekjoon.S10808;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int[] count = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int index = Character.getNumericValue(s.charAt(i)) - 10;
			count[index]++;
		}

		String result = "";
		for (int i = 0; i < 26; i++) {
			result += count[i] + " ";
		}

		System.out.println(result.trim());
	}
}
