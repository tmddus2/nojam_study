package programmers;

public class 숫자의_표현 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for(int i=1; i<n/2+1; i++) {
                int sum = i;
                for(int j=i+1; j<n+1; j++) {
                    sum += j;
                    if (sum == n) {
                        answer++;
                        break;
                    } else if (sum > n) {
                        break;
                    }
                }
            }
            return answer+1;
        }
    }
}
