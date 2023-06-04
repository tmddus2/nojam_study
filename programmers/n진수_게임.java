package programmers;

public class n진수_게임 {
    class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";
            int turn = 1;
            int num = 0;

            while (answer.length() != t) {
                String number = Integer.toString(num,n);
                for(int i=0; i<number.length(); i++) {
                    if ((turn-p)%m == 0 && answer.length()<t) {
                        answer += String.valueOf(number.charAt(i)).toUpperCase();
                    }
                    turn++;
                }
                num++;
            }
            return answer;
        }
    }
}
