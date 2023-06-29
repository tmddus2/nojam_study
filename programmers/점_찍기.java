package programmers;

public class 점_찍기 {
    class Solution {
        public long solution(int k, int d) {
            long answer = 0;

            for(int i=0; i<=d/k; i++) {
                int x = i*k;
                int maxY = (int)Math.sqrt((long)d*d-(long)x*x);
                answer += (int)(maxY/k)+1;
            }

            return answer;
        }

    }
}
