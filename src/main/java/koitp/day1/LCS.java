package koitp.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class LCS {
	//done
	static int CROSS = 2;
	static int LEFT = 4;
	static int UP = 6;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();

		int[][] numMatrix = new int[2][str1.length() + 1];
		int[][] pointMatrix = new int[str2.length() + 1][str1.length() + 1];

		int currentRowIndex = 0;

		for (int i = 1; i <= str2.length(); i++) {
			if ((i - 1) % 2 == 0) {
				currentRowIndex = 1;
			} else {
				currentRowIndex = 0;
			}

			for (int j = 1; j <= str1.length(); j++) {
				if (str2Array[i - 1] == str1Array[j - 1]) {
					numMatrix[currentRowIndex][j] = numMatrix[(currentRowIndex + 1) % 2][j - 1] + 1;
					pointMatrix[i][j] = CROSS;
				} else {
					if (numMatrix[(currentRowIndex + 1) % 2][j] > numMatrix[currentRowIndex][j - 1]) {
						numMatrix[currentRowIndex][j] = numMatrix[(currentRowIndex + 1) % 2][j];
						pointMatrix[i][j] = UP;
					} else {
						numMatrix[currentRowIndex][j] = numMatrix[currentRowIndex][j - 1];
						pointMatrix[i][j] = LEFT;
					}
				}
			}
		}

		int startRowIndex = str2.length();
		int startColIndex = str1.length();

		Stack<String> result = new Stack<>();
		while (startRowIndex > 0 && startColIndex > 0) {
			int point = pointMatrix[startRowIndex][startColIndex];
			switch (point) {
			case 2:
				result.push(str1.charAt(startColIndex-1) + "");
//				System.out.println(str1.charAt(startColIndex-1));
				startRowIndex--;
				startColIndex--;
				break;
			case 4:
				startColIndex--;
				break;
			case 6:
				startRowIndex--;
				break;
			default:
				
			}
		}

		while(!result.isEmpty()) {
			System.out.print(result.pop());
		}
//		System.out.println();

	}
}
