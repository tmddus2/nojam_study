package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj17088 {
    public static int N;
    public static int[] arr;
    public static boolean[] use;
    public static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        use = new boolean[N];
        ans = N*N;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(arr.length == 1) {
            System.out.println(0);
            return;
        }

        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                int[] copy = arr.clone();
                int count = 0;
                if (i!=0) {count+=1;};
                if (j!=0) {count+=1;};
                copy[0] += i;
                copy[1] += j;
                int gap = copy[1] - copy[0];
                boolean is = true;
                for(int k=2; k<N; k++) {
                    boolean temp = false;
                    for(int l=-1; l<=1; l++) {
                        if (copy[k] + l - copy[k-1] == gap) {
                            copy[k] += l;
                            if (l!=0) {count+=1;};
                            temp = true;
                            break;
                        }
                    }
                    if (!temp) {
                        is = false;
                        break;
                    }
                }
                if (is) {
                    ans = Math.min(ans, count);
                }
            }
        }
        if (ans == N*N) {
            System.out.println(-1);
        } else{
            System.out.println(ans);
        }

    }



}
