package baekjoon.S1008;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double a = sc.nextInt();
		double b = sc.nextInt();

		DecimalFormat df=new DecimalFormat("0.000000000");
		
		System.out.println(df.format(a/b));
	}
}
