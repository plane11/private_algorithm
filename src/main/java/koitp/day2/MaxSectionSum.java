package koitp.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSectionSum {
	// done
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(token.nextToken());

		token = new StringTokenizer(br.readLine());

		long max = Long.MIN_VALUE;
		long sum = 0;
		for (int i = 0; i < count; i++) {
			int num = Integer.parseInt(token.nextToken());

			sum += num;

			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}

		System.out.println(max);
	}

}
