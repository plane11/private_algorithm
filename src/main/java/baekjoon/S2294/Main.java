package baekjoon.S2294;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Main {
 
    static int coin[] = new int[10001];
    static int dp[] = new int[10001];
 
    public static void main(String[] args) throws FileNotFoundException {
         
        //System.setIn(new FileInputStream("sample.txt"));
         
        Scanner scanner = new Scanner(System.in);
        // n가지 종류 동전
        int n = scanner.nextInt();
        // k원
        int k = scanner.nextInt();
 
        for (int i = 1; i <= 10000; i++) {
            dp[i] = 987654321 ;         
        }
 
        for (int i = 0; i < n; i++) {
            int coinValue = scanner.nextInt();
            coin[i] = coinValue;
 
            for (int j = coin[i]; j <= k; j++) {
    //          System.out.println("j : " + j);
//              System.out.println("j - coin[" + i + "] : " + (j - coin[i]));
        //      System.out.println("j값 : " + dp[j] + " 비교값 : " + (dp[j - coin[i]]+1));
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);   
            //  System.out.println("세팅된 : " + j + " : " + dp[j]);
//              for (int l = 1; l < k+1; l++) {
//                System.out.print(dp[l] + " ");    
//              }
//              System.out.println("\n");
            }
//          System.out.println("----------------\n");
        }
 
        //System.out.println(dp);
        if (dp[k] == 987654321) {
            System.out.println("-1");
        }else{
            System.out.println(dp[k]);
        }
 
        scanner.close();
    }
 
}