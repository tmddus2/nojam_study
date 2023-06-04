package programmers;

public class 이진_변환_반복하기 {
    class Solution {
        public int[] ans = new int[]{0,0};
        public int[] solution(String s) {
            int[] answer = {};
            while (!s.equals("1")) {
                s = step1(s);
                s = step2(s.length());
            }
            answer = new int[]{ans[0], ans[1]};
            return answer;
        }

        public String step1(String s) {
            String result = "";
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') {
                    result += "1";
                } else {
                    ans[1]++;
                }
            }
            return result;
        }

        public String step2(int size) {
            String result = "";
            while (size != 0) {
                result = String.valueOf(size%2)+ result;
                size = size/2;
            }
            ans[0]++;
            return result;
        }
    }
}
