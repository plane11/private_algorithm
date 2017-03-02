package baekjoon.S10845;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int frontPoint = 1;
        int endPoint = 0;

        int[] queue = new int[N+1];

        for(int i = 0; i<=N; i++) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            if(strs[0].equals("push")) {
                queue[++endPoint] = Integer.parseInt(strs[1]);
            }else {
                int size = endPoint - frontPoint + 1;
                if(strs[0].equals("pop")) {
                    System.out.println(size == 0 ? -1 : queue[frontPoint++]);
                }else if(strs[0].equals("size")) {
                    System.out.println(size);
                }else if(strs[0].equals("empty")) {
                    System.out.println(size == 0 ? 1 : 0);
                }else if(strs[0].equals("front")) {
                    System.out.println(size == 0 ? -1 : queue[frontPoint]);
                }else if(strs[0].equals("back")) {
                    System.out.println(size == 0 ? -1 : queue[endPoint]);
                }
            }
        }

    }
}
