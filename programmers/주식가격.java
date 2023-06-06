package programmers;

public class 주식가격 {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = {};
            answer = new int[prices.length];
            for(int i=0; i<prices.length-1; i++) {
                int start = 0;
                for(int j=i+1; j<prices.length; j++) {
                    if (prices[i]<=prices[j]) {
                        start++;
                    } else {
                        start++;
                        break;
                    }
                }
                answer[i] = start;
            }
            answer[prices.length-1] = 0;
            return answer;
        }
    }
}
