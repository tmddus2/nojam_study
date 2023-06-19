package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj2294 {
    public static int n, k;
    public static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        for(int i=1; i<k+1; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }

        for(int i=0; i<coins.length; i++) {
            for(int j=coins[i]; j< dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }

        if (dp[k] == Integer.MAX_VALUE-1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
