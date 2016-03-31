package baekjoon.S2178;

import java.util.Scanner;

// time over
public class Main {

	static int row;
	static int col;
	static int[][] matrix;

	static int length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();

		matrix = new int[row][col];

		length = row * col; // init with maximum length

		sc.nextLine();

		for (int i = 0; i < row; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < col; j++) {
				matrix[i][j] = line.charAt(j) == '0' ? 0 : 1;
			}
		}

		dfs(0, 0, 0);

		System.out.println(length);
	}

	private static void dfs(int r, int c, int l) {
		l++;
//		System.out.println("visit(" + r + ", " + c + ")");

		if (r + 1 == row && c + 1 == col) {
			// 도착점 도착
			// System.out.println("Dest > " + l);
			if (length > l) {
				length = l;
			}
			return; // end
		}else {
	            if (length < l) {
	                return;
	            }
	        }
		
		matrix[r][c] = 0;

		// 우로이동
		if (c + 1 < col && matrix[r][c + 1] == 1) {
			dfs(r, c + 1, l);
		}

		// 아래로이동
		if (r + 1 < row  && matrix[r + 1][c] == 1) {
			dfs(r + 1, c, l);
		}

		// 위로이동
		if (r - 1 >= 0 && matrix[r - 1][c] == 1) {
			dfs(r - 1, c, l);
		}

		// 좌로이동
		if (c - 1 >= 0 && matrix[r][c - 1] == 1) {
			dfs(r, c - 1, l);
		}
		
		matrix[r][c] = 1;

	}
}
