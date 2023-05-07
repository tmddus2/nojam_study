package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class noj16953 {
    public static Long A,B;
    public static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dfs(1, A);
        System.out.println(ans);
    }

    public static void dfs(int depth, Long num) {
        if (ans != -1 || num > B) {
            return;
        }
        if (num.equals(B)) {

            ans = depth;
            return;
        }
        dfs(depth+1, num*2);
        dfs(depth+1, num*10+1);
    }

}
