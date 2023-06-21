package programmers;
import java.util.*;

public class 괄호_변환 {
    class Solution {
        public String solution(String p) {
            return recursive(p);
        }

        public String[] parseString(String s) {
            Queue<String> queue = new LinkedList<>();
            int left = 0;
            int right = 0;
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                    queue.add("(");
                } else if (s.charAt(i) == ')'){
                    right++;
                    queue.add(")");
                }
                if (left == right) {
                    break;
                }
            }

            String result = "";
            Iterator iter = queue.iterator();
            while(iter.hasNext()) {
                result += iter.next();
            }
            return new String[]{result, s.substring(result.length())};
        }

        public boolean isBalanced(String s) {
            int left = 0;
            int right = 0;

            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else if (s.charAt(i) == ')'){
                    right++;
                }
            }
            if (left == right) {
                return true;
            }
            return false;
        }

        public boolean isRight(String s) {
            if (!isBalanced(s)) {
                return false;
            }

            Stack<String> stack = new Stack<>();
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push("(");
                } else {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }

            if (stack.size() != 0) {
                return false;
            }
            return true;
        }


        public String recursive(String s) {
            String[] parsed = parseString(s);
            String u = parsed[0];
            String v = parsed[1];
            if (s.equals("")) {
                return "";
            }
            if (isRight(u)) {
                return u+recursive(v);
            }
            String result = "("+recursive(v)+")";
            String sub = u.substring(1, u.length()-1);
            for(int i=0; i<sub.length(); i++) {
                if (sub.charAt(i) == '(') {
                    result += ")";
                } else {
                    result += "(";
                }
            }
            return result;
        }
    }
}
