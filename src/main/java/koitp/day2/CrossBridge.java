package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CrossBridge {

	// static char strArray[];
	// static char line1Array[];
	// static char line2Array[];

	static String str;
	static String line1;
	static String line2;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("sample.txt")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		line1 = br.readLine();
		line2 = br.readLine();

		// strArray = str.toCharArray();
		// line1Array = line1.toCharArray();
		// line2Array = line2.toCharArray();

		int val1 = getCount(1, 0, 0);
		int val2 = getCount(2, 0, 0);

		System.out.println(val1 + val2);

	}

	private static int getCount(int bridgeNumber, int lineIndex, int stringPoint) {
		int count = 0;

		if (stringPoint == str.length()) {
			return 1;
		}

		if (bridgeNumber == 1) {
			for (int i = lineIndex; i < line1.length(); i++) {
				if (line1.charAt(i) == str.charAt(stringPoint)) {
					count += getCount(2, i + 1, stringPoint + 1);
				}
			}
		} else {
			for (int i = lineIndex; i < line2.length(); i++) {
				if (line2.charAt(i) == str.charAt(stringPoint)) {
					count += getCount(1, i + 1, stringPoint + 1);
				}
			}
		}

		return count;
	}

}
