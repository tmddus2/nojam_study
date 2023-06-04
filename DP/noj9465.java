package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj9465 {
    public static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            for(int j=0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(dp(sticker, n));
        }
    }

    public static int dp(int[][] sticker, int n) {
        int[][] dp = new int[2][n];
        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];

        for(int i=1; i<n; i++) {
            if (i == 1) {
                dp[0][i] = sticker[1][0]+sticker[0][1];
                dp[1][i] = sticker[0][0]+sticker[1][1];
            } else {
                dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1])+sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1])+sticker[1][i];
            }
        }

        return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}
