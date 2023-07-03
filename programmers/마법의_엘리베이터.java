package programmers;

public class 마법의_엘리베이터 {
    class Solution {
        public int NUM = Integer.MAX_VALUE;
        public int solution(int storey) {
            int answer = 0;
            dfs(storey, 0);
            answer = NUM;
            return answer;
        }

        public void dfs(int number, int sum) {
            if (sum >= NUM) {
                return;
            }
            String stringNum = String.valueOf(number);
            int lastDigit = ((int) stringNum.charAt(stringNum.length()-1)) - 48;
            int up = 10-lastDigit;
            int down = lastDigit;
            if (stringNum.length() == 1) {
                // 반례 포인트
                if (up >= down) { // 5일 때는 5->0 과 5->10->0 을 비교했을 때 그냥 down 시키는 1이 더 적다.
                    NUM = Math.min(sum+down, NUM);
                } else {
                    NUM = Math.min(sum+up+1, NUM); // up을 하면 자리수가 +1 되기 때문에 더하기 1을 해줘야 한다.
                }
                return;
            }

            String num1 = String.valueOf(number+up);
            num1 = num1.substring(0, num1.length()-1);
            String num2 = String.valueOf(number-down);
            num2 = num2.substring(0, num2.length()-1);
            dfs(Integer.parseInt(num1), sum+up);
            dfs(Integer.parseInt(num2), sum+down);
        }
    }
}
