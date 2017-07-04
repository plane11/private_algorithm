package koitp.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NearBitCount {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(token.nextToken());

		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());
			Integer.parseInt(token.nextToken());

			int value = Integer.parseInt(token.nextToken());
			int count = Integer.parseInt(token.nextToken());

			int[][][] matrix = new int[value + 1][count + 1][2];
			matrix[1][0][0] = 1;
			matrix[1][0][1] = 1;

			// matrix[n][k][e] : e로 끝나고 k개의 인접비트를 가지는 길이 n인 string의 수

			for (int n = 2; n <= value; n++) {
				for (int k = 0; k <= count; k++) {
					matrix[n][k][0] = matrix[n - 1][k][0] + matrix[n - 1][k][1];
					matrix[n][k][1] = matrix[n - 1][k][0] + (k > 0 ? matrix[n - 1][k - 1][1] : 0);
				}
			}

			System.out.println(t + " " + (matrix[value][count][0] + matrix[value][count][1]));
		}

	}
}
