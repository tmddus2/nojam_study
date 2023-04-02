import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class noj15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] t = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(t[j]);
            }
        }

        int[][] dp = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                dp[i][j] = dp[i][j - 1] + map[i-1][j-1];
            }
        }

        /*
        for (int i=0;i<N+1;i++) {
            for (int j=0;j<M+1;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
         */

        int K = Integer.parseInt(br.readLine());
        for (int i=0; i<K; i++) {
            String[] range = br.readLine().split(" ");
            int x1 = Integer.parseInt(range[0]);
            int y1 = Integer.parseInt(range[1]);
            int x2 = Integer.parseInt(range[2]);
            int y2 = Integer.parseInt(range[3]);

            int sum = 0;
            for (int j=x1; j<=x2; j++) {
                sum = sum + (dp[j][y2] - dp[j][y1-1]);
            }
            System.out.println(sum);
        }
    }
}
