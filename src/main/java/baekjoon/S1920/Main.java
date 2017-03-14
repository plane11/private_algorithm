package baekjoon.S1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int[] nArray;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] strs = br.readLine().split(" ");
        nArray = new int[N+1];
        for(int i = 1 ; i<= N; i++) {
            nArray[i] = Integer.parseInt(strs[i-1]);
        }

        Arrays.sort(nArray);

        int M = Integer.parseInt(br.readLine());

        strs = br.readLine().split(" ");
        for(int i = 1 ; i<= M; i++) {
            int num = Integer.parseInt(strs[i-1]);

            find(num);
        }
    }

    private static void find(int num) {
        int left = 1;
        int right = nArray.length - 1;

        int result = 0;
        while(true) {

            if(right < left) {
                result = 0;
                break;
            }else if(right == left && nArray[right] == num) {
                result = 1;
                break;
            }

            int middle = (right + left) / 2;
            if(nArray[middle] > num) {
                right = middle - 1;
            }else if(nArray[middle] < num) {
                left = middle + 1;
            }else {
                result = 1;
                break;
            }

        }

        System.out.println(result);
    }

}
