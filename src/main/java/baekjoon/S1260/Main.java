package baekjoon.S1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, M, V;
    static int[][] matrix;
    static int[] visited;
    static int[] queue;
    static int qFront = 0, qRear = 0;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        M = Integer.parseInt(strs[1]);
        V = Integer.parseInt(strs[2]);
        N = Integer.parseInt(strs[0]);

        matrix = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            strs = br.readLine().split(" ");
            matrix[Integer.parseInt(strs[0])][Integer.parseInt(strs[1])] = 1;
            matrix[Integer.parseInt(strs[1])][Integer.parseInt(strs[0])] = 1;
        }

        calcDfs();
        calcBfs();
    }

    private static void calcDfs() {
        visited = new int[N+1];
        sb.append(V + " ");
        visited[V] = 1;
        dfs(V);
        System.out.println(sb.toString().trim());
    }

    private static void dfs(int position) {
        for(int i = 1; i<=N; i++) {
            int val = matrix[position][i];
            if(val > 0 && visited[i] < 1) {
                sb.append(i + " ");
                visited[i] = 1;
                dfs(i);
            }
        }
        return;
    }

    private static void calcBfs() {
        sb = new StringBuffer();
        visited = new int[N+1];
        queue = new int[N+1];
        queue[++qRear] = V;
        visited[V] = 1;
        sb.append(V + " ");

        bfs();
        System.out.println(sb.toString().trim());
    }

    private static void bfs() {
        while(qFront < qRear) {
            int val = queue[++qFront];

            for(int i = 1; i<=N; i++)  {
                int n = matrix[val][i];
                if(n > 0 && visited[i] < 1) {
                    queue[++qRear] = i;
                    visited[i] = 1;
                    sb.append(i + " ");
                }
            }
        }
    }
}
