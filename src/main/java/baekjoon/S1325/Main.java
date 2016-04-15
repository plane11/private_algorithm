import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class MyScanner {
        BufferedReader br;

        int idx = 0;
        String[] arr = new String[0];

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
            }

        public int nextInt() throws IOException {
            if (idx >= arr.length) {
                arr = br.readLine().split(" ");
                idx = 0;
                }
            return Integer.parseInt(arr[idx++]);
            }
        }

    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n+1][1];
        for (int i = 0; i < m; i++) {
            int e = sc.nextInt();
            int s = sc.nextInt();
            map[s][0]++;
            if (map[s][0] >= map[s].length) {
                expand(map, s);
                }
            map[s][map[s][0]] = e;
            }

        int max = 0;
        List<Integer> result = new ArrayList<>();
        int[] queue = new int[200000];
        boolean[] visit = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            int cnt = bfs(map, queue, visit, i);
            if (cnt > max) {
                max = cnt;
                result.clear();
                result.add(i);
                } else if (cnt == max) {
                result.add(i);
                }
            Arrays.fill(visit, false);
            }

        Collections.sort(result);
        System.out.println(result.toString().replaceAll("\\[|\\]|,", ""));

        }

    private static int bfs(int[][] map, int[] queue, boolean[] visit, int start) {

        int result = 0;
        int front = 0;
        int rear = 1;
        queue[front] = start;

        while (front < rear) {
            int node = queue[front++];
            if (visit[node]) {
                continue;
}
            visit[node] = true;
            result++;

            for (int j = 1; j <= map[node][0]; j++) {
                if (visit[map[node][j]]) {
                    continue;
                    }
                queue[rear++] = map[node][j];
                }
            }

        return result;
        }

    private static void expand(int[][] map, int s) {
        int[] temp = map[s];
        map[s] = new int[temp.length+1000];
        System.arraycopy(temp, 0, map[s], 0, temp.length);
        }
}
