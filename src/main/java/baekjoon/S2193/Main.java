import java.util.Scanner;
 
/**
 * Created by actmember on 4/19/16.
 */
public class Main {
 
    static int countZero;
    static int N;
    static long[] cache = new long[92];
 
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
 
        N = scanner.nextInt();
 
        if(N < 3){
            System.out.println(1);
        } else{
            for(int i=0; i<92; i++){
                cache[i] = -1;
            }
 
            cache[0] = 0;
            cache[1] = 1;
            cache[2] = 2;
 
            calc(3);
 
            System.out.println(cache[N-1]);
        }
    }
 
    private static void calc(int n) {
//        System.out.println(n);
 
        while(n <= N){
            //System.out.println(n + " => " + cache[n-1] + " + " + cache[n-2]);
            cache[n] = cache[n-1] + cache[n-2];
            n++;
        }
 
    }
 
 
}
