package baekjoon.S10802;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		String[] nums = line.split(" ");
		
		long start = Long.parseLong(nums[0]);
		long end = Long.parseLong(nums[1]);

		int startExp = nums[0].length() - 1; // 2
		int endExp = nums[1].length() - 1; // 3

		double startMod = Math.pow(10, startExp); // 100
		double blockStart = (startExp + 1) * startMod; // 300

		double endMod = Math.pow(10, endExp); // 1000
		double blockEnd = (endExp + 1) * endMod; // 1000

		countBlock(start, blockStart);
		countBlock(blockEnd, end);

	}

	private static void countBlock(double start, double end) {
		System.out.println("Block Count : " + start + " ~ " + end);
	}

}
