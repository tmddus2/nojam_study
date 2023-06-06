package programmers;

public class 땅따먹기 {
    class Solution {
        int solution(int[][] land) {
            int[][] dp = new int[land.length][land[0].length];
            for(int i=0; i<land[0].length; i++) {
                dp[0][i] = land[0][i];
            }

            for(int i=1; i<land.length; i++) {
                for(int j=0; j<land[0].length; j++) {
                    int max_value = Integer.MIN_VALUE;
                    for(int k=0; k<land[0].length; k++) {
                        if (k != j) {
                            max_value = Math.max(max_value, dp[i-1][k]);
                        }
                    }
                    dp[i][j] = max_value+land[i][j];
                }
            }
            int answer = Integer.MIN_VALUE;
            for(int i=0; i<dp[0].length; i++) {
                answer = Math.max(answer, dp[dp.length-1][i]);
            }
            return answer;
        }

    }
}
