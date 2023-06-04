package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class noj9461 {
    public static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 1) {
                System.out.println(1);
            } else if (N == 2) {
                System.out.println(1);
            } else if (N == 3) {
                System.out.println(1);
            } else if (N == 4) {
                System.out.println(2);
            } else if (N == 5) {
                System.out.println(2);
            } else {
                int[] dp = new int[N+1];
                dp[1] = 1;
                dp[2] = 1;
                dp[3] = 1;
                dp[4] = 2;
                dp[5] = 2;
                for(int j=6; j<N+1; j++) {
                    dp[j] = dp[j-1]+dp[j-5];
                }
                System.out.println(dp[N]);
            }
        }
    }
}
