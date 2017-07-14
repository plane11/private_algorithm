package koitp.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetPowNumber {

	// done
	static long A, M;
	static long DIV = 1000000007;

	static long ANS = 1;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());

		A = Long.parseLong(token.nextToken()) % DIV;
		M = Long.parseLong(token.nextToken());

		ANS = power(A, M);

		System.out.println(ANS);
	}

	// O(logN) -> timeout
	static long half_power(long a, long m) {
		if (m == 0) {
			return 1;
		} else if (m == 1) {
			return a;
		}

		// half_power를 변수로 분리해서 시간 줄여주기
		if (m % 2 == 0) { // 2이상 짝수승
			return half_power(a, m / 2) * half_power(a, m / 2) % DIV;
		} else { // 2이상 홀수승
			return half_power(a, m / 2) * half_power(a, m / 2) % DIV * a % DIV;
		}

	}

	static long power(long a, long m) {
		if (m == 0) {
			return 1;
		}

		long v = power(a, m / 2);

		if (m % 2 == 0) {
			return v * v % DIV;
		} else {
			return v * v % DIV * a % DIV;
		}
	}

}
