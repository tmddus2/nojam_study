package programmers;
import java.util.*;

public class 문자열_압축 {
    class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            for(int i=1; i<=s.length(); i++) {
                String result = compress(s, i);
                if (answer > result.length()) {
                    answer = result.length();
                }
            }
            return answer;
        }

        public String compress(String s, int unit) {
            Stack<String> stack = new Stack<>();

            for(int i=0; i<s.length(); i++) {
                if (i+unit>s.length()) {
                    stack.push(s.substring(i));
                    break;
                }
                stack.push(s.substring(i, i+unit));
                i += (unit-1);
            }

            String result = "";
            String now = stack.pop();
            int count = 1;
            while(!stack.isEmpty()) {
                if (!stack.peek().equals(now)) {
                    result = now+result;
                    if (count != 1) {
                        result = Integer.toString(count)+result;
                    }
                    now = stack.pop();
                    count = 1;
                    continue;
                }
                stack.pop();
                count++;
            }
            result = now+result;
            if (count != 1) {
                result = Integer.toString(count)+result;
            }
            return result;
        }
    }
}
