package programmers;
import java.util.*;

public class 괄호_회전하기 {
    class Solution {
        public int solution(String s) {
            int answer = -1;
            if (check(s)) {
                answer = 1;
            } else {
                answer = 0;
            }
            for(int i=0; i<s.length()-1; i++) {
                s = s.substring(1)+String.valueOf(s.charAt(0));
                if (check(s)) {
                    answer++;
                }
            }
            return answer;
        }

        public boolean check(String s) {
            Stack<String> stack = new Stack<>();
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push("(");
                } else if (s.charAt(i) == ')') {
                    if (stack.size() == 0) {
                        return false;
                    } else {
                        String pop = stack.pop();
                        if (!pop.equals("(")) {
                            return false;
                        }
                    }
                } else if (s.charAt(i) == '[') {
                    stack.push("[");
                } else if (s.charAt(i) == ']') {
                    if (stack.size() == 0) {
                        return false;
                    } else {
                        String pop = stack.pop();
                        if (!pop.equals("[")) {
                            return false;
                        }
                    }
                } else if (s.charAt(i) == '{') {
                    stack.push("{");
                } else if (s.charAt(i) == '}') {
                    if (stack.size() == 0) {
                        return false;
                    } else {
                        String pop = stack.pop();
                        if (!pop.equals("{")) {
                            return false;
                        }
                    }
                }
            }

            if (stack.size() != 0) {
                return false;
            }
            return true;
        }
    }
}
