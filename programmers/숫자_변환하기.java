package programmers;

public class 숫자_변환하기 {
    class Solution {
        public int ans = Integer.MAX_VALUE;
        public int solution(int x, int y, int n) {
            int answer = 0;
            int[] dp = new int[y+1];
            for(int i=0; i<dp.length; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[x] = 0;
            for(int i=x+1; i<dp.length; i++) {
                int min = Integer.MAX_VALUE;
                if (i-n >= x) {
                    min = Math.min(dp[i-n], min);
                }
                if (i%2 == 0) {
                    min = Math.min(dp[i/2], min);
                }
                if (i%3 == 0) {
                    min = Math.min(dp[i/3], min);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min+1;
                }
            }

            answer = dp[dp.length-1];
            if (answer == Integer.MAX_VALUE) {
                return -1;
            }
            return answer;
        }


    }
}
