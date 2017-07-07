package koitp.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Balloon {

	// done
	static int N;

	static int[] BH = new int[1000001];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer token = new StringTokenizer(br.readLine());

		// init
		int h = Integer.parseInt(token.nextToken());
		int count = 1;

		BH[h - 1] = 1;

		for (int n = 2; n <= N; n++) {
			int now = Integer.parseInt(token.nextToken());

			if (BH[now] > 0) {
				BH[now]--;
				BH[now - 1] += 1;
			} else {
				BH[now - 1] += 1;
				count++;
			}

		}

		System.out.println(count);
	}
}
