package koitp.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSum {

	static int N, Q;

	static int[] D;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Q = Integer.parseInt(br.readLine());

		int treeSize = (int) Math.pow(2, Integer.toBinaryString(N).length() + 1);
		int leafSize = treeSize / 2;

		D = new int[treeSize];

		for (int i = 1; i <= leafSize; i++) {
			D[i + leafSize - 1] = i;
		}

		for (int i = leafSize - 1; i > 0; i--) {
			D[i] = D[i * 2] + D[i * 2 + 1];
		}

		StringTokenizer token;
		for (int q = 1; q <= Q; q++) {
			token = new StringTokenizer(br.readLine());

			switch (token.nextToken()) {
			case "0":
				int num1Index = Integer.parseInt(token.nextToken());

				int num1 = D[num1Index + leafSize - 1];
				int num2 = Integer.parseInt(token.nextToken());

				D[num1Index + leafSize - 1] = num2;

				int point = num1Index + leafSize - 1;
				while (point > 1) {
					D[point / 2] += num2 - num1;
					point /= 2;
				}

				break;
			case "1":
				int front = Integer.parseInt(token.nextToken()) + leafSize - 1;
				int rear = Integer.parseInt(token.nextToken()) + leafSize - 1;

				int sum = 0;
				while (front <= rear) {
					if (front == rear) {
						sum += D[front];
						front++;
						rear--;
						break;
					}

					if (front % 2 == 1) {
						sum += D[front];
						front++;
					}

					if (rear % 2 == 0) {
						sum += D[rear];
						rear--;
					}

					front = front / 2;
					rear = rear / 2;
				}

				System.out.println(sum);
				break;
			}
		}
	}

}
