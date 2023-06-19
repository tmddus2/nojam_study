package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj1208 {
    public static int N;
    public static int S;
    public static int[] seq;
    public static int ans = 0;
    public static boolean part = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        if (S==0) {
            System.out.println(ans-1);
        } else {
            System.out.println(ans);
        }

    }

    public static void dfs(int index, int sum) {
        if(index == N) {
            if (sum == S) ans += 1;
            return;
        }
        dfs(index+1, sum);
        dfs(index+1, sum+seq[index]);
    }
}
