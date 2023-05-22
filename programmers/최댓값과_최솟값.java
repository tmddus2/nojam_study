package programmers;
import java.util.*;
public class 최댓값과_최솟값 {
    class Solution {
        public String solution(String s) {
            StringTokenizer st = new StringTokenizer(s);
            int value = Integer.parseInt(st.nextToken());
            int max = value;
            int min = value;
            while(st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken());
                if (value > max) {
                    max = value;
                }
                if (value < min) {
                    min = value;
                }
            }
            String answer = String.valueOf(min)+" "+String.valueOf(max);
            return answer;
        }
    }
}
