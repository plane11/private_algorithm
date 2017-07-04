package koitp.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Set {

	static int[] large;
	static int[] small;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int num1 = Integer.parseInt(token.nextToken());
		int num2 = Integer.parseInt(token.nextToken());

		int N, M;

		StringTokenizer token1 = new StringTokenizer(br.readLine());
		StringTokenizer token2 = new StringTokenizer(br.readLine());

		if (num1 < num2) {
			small = new int[num1 + 1];
			large = new int[num2 + 1];

			for (int n = 1; n <= num1; n++) {
				small[n] = Integer.parseInt(token1.nextToken());
			}

			for (int m = 1; m <= num2; m++) {
				large[m] = Integer.parseInt(token2.nextToken());
			}

			N = num1;
			M = num2;
		} else {
			large = new int[num1 + 1];
			small = new int[num2 + 1];

			for (int n = 1; n <= num1; n++) {
				large[n] = Integer.parseInt(token1.nextToken());
			}

			for (int m = 1; m <= num2; m++) {
				small[m] = Integer.parseInt(token2.nextToken());
			}

			N = num2;
			M = num1;
		}
		
		Arrays.sort(small);
		Arrays.sort(large);

		int min = (int) 2e9;

		int sizeDiff = Math.abs(M - N);
		for (int i = 0; i <= sizeDiff; i++) {

			int cal = 0;
			for (int n = 1; n <= N; n++) {
				cal += Math.abs(small[n] - large[n + i]);
//				 System.out.println(small[n] + " - " + large[n + i]);
			}

			min = Math.min(min, cal);
		}

		System.out.println(min);

	}

}
