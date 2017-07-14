package koitp.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class DicisionSet {
	// done
	
	static int T, N;
	static char[] A;
	static boolean[][][] D, vis;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int ts = 1; ts <= T; ts++) {
			{
				String tmp = br.readLine();
				N = tmp.length();
				A = new char[N + 1];
				for (int i = 1; i <= N; i++)
					A[i] = tmp.charAt(i - 1);
			}
			D = new boolean[N + 1][N + 1][5];
			vis = new boolean[N + 1][N + 1][5];
			boolean ans = dy(1, N, 0);
			System.out.println("Word #" + ts + ": " + (ans ? "Set" : "No Set"));
		}
	}

	static boolean dy(int s, int e, int t) {
		if (vis[s][e][t])
			return D[s][e][t];
		vis[s][e][t] = true;
		boolean ret = false;
		if (t == 0) {
			// is set?
			if (A[s] == '{' && A[e] == '}' && dy(s + 1, e - 1, 1))
				ret = true;
		} else if (t == 1) {
			// is elementlist?
			if (s > e || dy(s, e, 2))
				ret = true;
		} else if (t == 2) {
			// is list?
			if (dy(s, e, 3))
				ret = true;
			else {
				for (int i = s + 1; i < e; i++)
					if (A[i] == ',') {
						if (dy(s, i - 1, 3) && dy(i + 1, e, 2)) {
							ret = true;
							break;
						}
					}
			}
		} else if (t == 3) {
			// is element?
			if (dy(s, e, 4) || dy(s, e, 0))
				ret = true;
		} else {
			// is atom?
			if (s == e)
				ret = true;
		}
		return D[s][e][t] = ret;
	}

}
