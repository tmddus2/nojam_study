package programmers;

public class 나라의_숫자 {
    class Solution {
        public String solution(int n) {
            String answer = "";

            while(n > 0) {
                if (n%3 == 0) {
                    answer = "4"+answer;
                    n -= 1;
                } else if (n%3 == 1) {
                    answer = "1"+answer;
                } else if (n%3 == 2) {
                    answer = "2"+answer;
                }

                n /= 3;
            }
            return answer;
        }
    }
}
