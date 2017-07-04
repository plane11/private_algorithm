package koitp.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AssemblyLineScheduling {
	//done
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int e1 = Integer.parseInt(token.nextToken());
		int e2 = Integer.parseInt(token.nextToken());
		int x1 = Integer.parseInt(token.nextToken());
		int x2 = Integer.parseInt(token.nextToken());

		int[] line1Array = new int[N + 1]; // N
		int[] line2Array = new int[N + 1]; // N

		int[] oneToTwo = new int[N + 1]; // N-1
		int[] twoToOne = new int[N + 1]; // N-1

		StringTokenizer line1ArrayToken = new StringTokenizer(br.readLine());
		StringTokenizer line2ArrayToken = new StringTokenizer(br.readLine());
		StringTokenizer oneToTwoToken = new StringTokenizer(br.readLine());
		StringTokenizer twoToOneToken = new StringTokenizer(br.readLine());

		for (int n = 1; n <= N; n++) {
			line1Array[n] = Integer.parseInt(line1ArrayToken.nextToken());
			line2Array[n] = Integer.parseInt(line2ArrayToken.nextToken());
			if (n < N) {
				oneToTwo[n] = Integer.parseInt(oneToTwoToken.nextToken());
				twoToOne[n] = Integer.parseInt(twoToOneToken.nextToken());
			}
		}

		int[][] matrix = new int[2][N + 1];

		for (int n = 1; n <= N; n++) {
			if (n == 1) {
				matrix[0][n] = e1 + line1Array[n];
				matrix[1][n] = e2 + line2Array[n];
			} else {
				matrix[0][n] = Math.min(matrix[0][n - 1] + line1Array[n], matrix[1][n - 1] + line1Array[n] + twoToOne[n - 1]);
				matrix[1][n] = Math.min(matrix[1][n - 1] + line2Array[n], matrix[0][n - 1] + line2Array[n] + oneToTwo[n - 1]);
			}

			if (n == N) {
				matrix[0][n] += x1;
				matrix[1][n] += x2;
			}

		}

		System.out.println(Math.min(matrix[0][N], matrix[1][N]));

	}
}
