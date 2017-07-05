package koitp.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class NQueen_Backtrack {
	// done
	static int N;
	static int count;
	static int[] sol = new int[16];
	static int[] col = new int[16];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		count = 0;
		backstrack(0);
		System.out.println(count);

	}

	private static void backstrack(int row) {
		if (row == N) {
			count++;
			return;
		}

		loop: for (int i = 0; i < N; i++) {
			if (col[i] == 1) {
				continue loop;
			}

			for (int j = 0; j < row; j++) {
				if (Math.abs(row - j) == Math.abs(i - sol[j])) {
					continue loop;
				}
			}

			sol[row] = i;
			col[i] = 1;
			backstrack(row + 1);
			col[i] = 0;
		}
	}

}
