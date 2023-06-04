package programmers;
import java.util.*;

public class 올바른_괄호 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<String> stack = new Stack();
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (c=='(') {
                    stack.push("(");
                }
                if (c==')') {
                    if (stack.size()>0) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }

            if (stack.size()!=0) {
                answer = false;
            }


            return answer;
        }
    }
}
