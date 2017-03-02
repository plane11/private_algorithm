package baekjoon.S10828;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int point = 0;

        int[] stack = new int[N+1];

        for(int i=0; i<=N; i++){
            String str = sc.nextLine();

            String[] strs = str.split(" ");
            if(strs[0].equals("push")) {
                stack[++point] = Integer.parseInt(strs[1]);
            }else if(strs[0].equals("top")) {
                System.out.println(point == 0 ? -1 : stack[point]);
            }else if(strs[0].equals("size")) {
                System.out.println(point);
            }else if(strs[0].equals("empty")) {
                System.out.println(point == 0 ? 1 : 0);
            }else if(strs[0].equals("pop")) {
                System.out.println(point == 0 ? -1 : stack[point--]);
            }
        }

    }
}
