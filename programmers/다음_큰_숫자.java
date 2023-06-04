package programmers;

public class 다음_큰_숫자 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int one1 = getNumber(n);
            while(true) {
                n++;
                if(getNumber(n) == one1) {
                    answer = n;
                    break;
                }
            }
            return answer;
        }

        public int getNumber(int num) {
            int ans = 0;
            while (num != 0) {
                if (num%2==1) {
                    ans++;
                }
                num /= 2;
            }
            return ans;
        }
    }
}
