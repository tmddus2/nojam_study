package programmers;
import java.util.*;

public class 수식_최대화 {
    class Solution {
        public String[][] operators = new String[][]{{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},{"*","-","+"},{"*","+","-"}};
        public long solution(String expression) {
            long answer = Long.MIN_VALUE;
            for(int i=0; i<6; i++) {
                String copy = expression;
                ArrayList<String> EXP = new ArrayList<>();
                while(!copy.equals("")) {
                    String token = getToken(copy);
                    copy = copy.substring(token.length());
                    EXP.add(token);
                }

                for(int j=0; j<3; j++) {
                    if (operators[i][j].equals("+")) {
                        EXP = calPlus(EXP);
                    } else if (operators[i][j].equals("-")) {
                        EXP = calMinus(EXP);
                    } else if (operators[i][j].equals("*")) {
                        EXP = calMulti(EXP);
                    }
                }

                answer = Math.max(answer, Math.abs(Long.parseLong(EXP.get(0))));
            }

            return answer;
        }

        public ArrayList<String> calPlus(ArrayList<String> arr) {
            for(int i=0; i<arr.size(); i++) {
                if (arr.get(i).equals("+")) {
                    Long value = Long.parseLong(arr.get(i-1))+Long.parseLong(arr.get(i+1));
                    arr.set(i-1, String.valueOf(value));
                    arr.remove(i);
                    arr.remove(i);
                    i--;
                }
            }

            return arr;
        }

        public ArrayList<String> calMinus(ArrayList<String> arr) {
            for(int i=0; i<arr.size(); i++) {
                if (arr.get(i).equals("-")) {
                    Long value = Long.parseLong(arr.get(i-1))-Long.parseLong(arr.get(i+1));
                    arr.set(i-1, String.valueOf(value));
                    arr.remove(i);
                    arr.remove(i);
                    i--;
                }
            }
            return arr;
        }

        public ArrayList<String> calMulti(ArrayList<String> arr) {
            for(int i=0; i<arr.size(); i++) {
                if (arr.get(i).equals("*")) {
                    Long value = Long.parseLong(arr.get(i-1))*Long.parseLong(arr.get(i+1));
                    arr.set(i-1, String.valueOf(value));
                    arr.remove(i);
                    arr.remove(i);
                    i--;
                }
            }

            return arr;
        }

        public String getToken(String s) {
            if (s.equals("")) {
                return "";
            }
            if (s.charAt(0)=='+' || s.charAt(0)=='-' || s.charAt(0)=='*') {
                return String.valueOf(s.charAt(0));
            }
            String result = "";
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*') {
                    break;
                }
                result += String.valueOf(s.charAt(i));
            }
            return result;
        }
    }
}
