package koitp.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Nugget {

	// done
	static int N;
	static long[] nugget;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nugget = new long[N + 1];

		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			nugget[n] = Long.parseLong(token.nextToken());
		}

		nugget[0] = 0;

		Arrays.sort(nugget);
		
		long ans = -1;
		long sum = 0;
		for (int n = 1; n <= N; n++) {
			if(sum + 1 < nugget[n]){
				break;
			}
			
			sum += nugget[n];
		}

		ans = sum + 1;
		System.out.println(ans);

	}
}
