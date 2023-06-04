package programmers;
import java.util.*;

public class 짝지어_제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            int answer = -1;
            Stack<String> stack = new Stack();
            for(int i=0; i<s.length(); i++) {
                String c = String.valueOf(s.charAt(i));
                if (stack.size() == 0) {
                    stack.push(c);
                    continue;
                }
                if (stack.peek().equals(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }

            }
            if (stack.size() == 0) {
                answer = 1;
            } else {
                answer = 0;
            }

            return answer;
        }
    }
}
