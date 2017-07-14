package koitp.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FarthestPoint {

	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer token;
		for (int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());
			Integer.parseInt(token.nextToken());
			Integer.parseInt(token.nextToken());
		}

		System.out.println(-1);
	}
}
