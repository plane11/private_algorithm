package koitp.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BoyScout {

	static int N;
	static Tree[] T;
	static List<Integer> stack = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		T = new Tree[N + 1];
		
		StringTokenizer token;
		for (int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());

			int x = (int) (Float.parseFloat(token.nextToken()) * 100);
			int y = (int) (Float.parseFloat(token.nextToken()) * 100);

			T[n] = new Tree(x, y);
		}

		for (int i = 2; i <= N; i++) {
			if (T[1].y > T[i].y || (T[1].y == T[i].y) && T[1].x > T[i].x) {
				Tree temp = T[1];
				T[1] = T[i];
				T[i] = temp;
			}
		}

		Arrays.sort(T, 2, N + 1, new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				int k = ccw(T[1], o1, o2);
				if (k != 0)
					return -k;
				return (o1.y + Math.abs(o1.x - T[1].x)) - (o2.y + Math.abs(o2.x - T[1].x));
			}
		});

		stack.add(1);
		stack.add(2);

		for (int n = 3; n <= N; n++) {
			while (!stack.isEmpty()) {
				int a = stack.get(stack.size() - 2);
				int b = stack.get(stack.size() - 1);
				if (ccw(T[a], T[b], T[n]) <= 0)
					stack.remove(stack.size() - 1);
				else
					break;
			}
			stack.add(n);
		}
		
		System.out.println(stack.size());
	}

	private static int ccw(Tree tree, Tree o1, Tree o2) {
		long result = (long) tree.x * o1.y + (long) o1.x * o2.y + (long) o2.x * tree.y - (long) tree.y * o1.x
				- (long) o1.y * o2.x - (long) o2.y * tree.x;
		if (result > 0)
			return 1;
		else if (result < 0)
			return -1;
		else
			return 0;
	}
}

class Tree {
	int x;
	int y;

	public Tree(int x, int y) {
		this.x = x;
		this.y = y;
	}
}