package programmers;

public class 피보나치_수 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int[] p = new int[n+1];
            p[1] = 1;
            p[2] = 1;
            for(int i=3; i<n+1; i++) {
                p[i] = p[i-1] + p[i-2];
                if (p[i] >= 1234567) {
                    p[i] = p[i]%1234567;
                }
            }
            answer = p[n];

            return answer;
        }
    }
}
