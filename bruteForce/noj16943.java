package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj16943 {
    public static int[] A;
    public static int B;
    public static boolean[] visited;
    public static int ans = -1;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] chars = st.nextToken().toCharArray();
        A = new int[chars.length];
        for(int i=0; i<chars.length; i++) {
            A[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[A.length];
        N = A.length;

        dfs(N,0);
        System.out.println(ans);
    }

    public static void dfs(int digit, int num) {
        if (num >= B) {
            return;
        }
        if(digit==0 && num < B) {
            ans = Math.max(ans, num);
            return;
        }
        for(int i=0; i<A.length; i++) {
            if (digit == N && A[i] == 0) {
                continue;
            }
            if(visited[i] == false) {
                visited[i] = true;
                dfs(digit-1, num+calNum(digit,A[i]));
                visited[i] = false;
            }
        }
    }

    public static int calNum(int digit, int value) {
        int result = value;
        for (int d=0; d<digit-1; d++) {
            result *= 10;
        }
        return result;
    }
}
