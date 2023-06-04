package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj2293 {
    public static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i=0; i< coins.length; i++) {
            for(int j=1; j<k+1; j++) {
                if (j-coins[i] >= 0) {
                    dp[j] += dp[j-coins[i]];
                }
            }
        }


        System.out.println(dp[k]);

    }
}
