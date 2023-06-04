package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class noj2579 {
    public static int N;
    public static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N+1];
        for(int i=1; i<N+1; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[N+1];
        dp[1] = scores[1];

        for(int i=2; i<N+1; i++) {
            if (i==2) {
                dp[i] = dp[i-1] + scores[i];
            } else if (i==3) {
                dp[i] = Math.max(scores[i-2], scores[i-1]) + scores[i];
            } else {
                dp[i] = Math.max(dp[i-2], dp[i-3]+scores[i-1]) + scores[i];
            }
        }
        System.out.println(dp[N]);

    }
}
