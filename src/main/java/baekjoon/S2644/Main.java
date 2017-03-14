package baekjoon.S2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");

        int X = Integer.parseInt(strs[0]);
        int Y = Integer.parseInt(strs[1]);

        int M = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N+1][N+1];

        for(int i = 0; i<M; i++) {
            strs = br.readLine().split(" ");
            matrix[Integer.parseInt(strs[0])][Integer.parseInt(strs[1])] = 1;
            matrix[Integer.parseInt(strs[1])][Integer.parseInt(strs[0])] = 1;
        }

        int min = Integer.MIN_VALUE;


    }

}
