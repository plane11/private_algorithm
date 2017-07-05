package koitp.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuildHouse {

	// done
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int[] D = new int[N];

		for (int n = 0; n < N; n++) {
			D[n] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(D);

		int startIndex = 0;
		int endIndex = N - 1;

		int base = X * 10000000;
		boolean hasAns = false;

		while (startIndex < endIndex) {
			int sum = D[startIndex] + D[endIndex];
			if (sum == base) {
				hasAns = true;
				break;
			} else if (sum < base) {
				startIndex++;
			} else {
				endIndex--;
			}
		}

		if (hasAns) {
			System.out.println("yes " + D[startIndex] + " " + D[endIndex]);
		} else {
			System.out.println("danger");
		}

	}
}
