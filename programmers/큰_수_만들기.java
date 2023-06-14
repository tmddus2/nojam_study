package programmers;
import java.util.*;

public class 큰_수_만들기 {
    class Solution {
        public String solution(String number, int k) {
            StringBuilder answer = new StringBuilder();
            int left = k;
            int start = 0;
            while(answer.length() != number.length()-k) {
                int index = start;
                for(int i=start; i<=start+left; i++) {
                    if (number.charAt(index) < number.charAt(i)) {
                        index = i;
                    }
                }
                answer.append(String.valueOf(number.charAt(index)));
                left -= (index-start);
                start = index+1;

            }

            return answer.toString();
        }
    }
}
