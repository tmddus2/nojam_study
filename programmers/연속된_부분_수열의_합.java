package programmers;

public class 연속된_부분_수열의_합 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {};
            int left = 0;
            int right = sequence.length-1;
            int sum = 0;
            for(int L=0, R=0; L<sequence.length; L++) {
                while(sum < k && R < sequence.length) {
                    sum += sequence[R];
                    R++;
                }
                if (sum == k) {
                    if (right-left > R-L-1) {
                        left = L;
                        right = R-1;
                    }
                }
                sum -= sequence[L];
            }

            answer = new int[]{left, right};
            return answer;
        }
    }
}
