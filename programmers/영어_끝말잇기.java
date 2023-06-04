package programmers;
import java.util.*;

public class 영어_끝말잇기 {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {};
            answer = new int[]{0,0};
            Set<String> set = new HashSet<>();
            set.add(words[0]);
            String before = words[0];
            int turn = 2;
            int total = 1;
            for(int i=1; i<words.length; i++) {
                if (set.contains(words[i]) || words[i].charAt(0) != before.charAt(before.length()-1)) {
                    answer[0] = turn;
                    answer[1] = total;
                    break;
                }
                set.add(words[i]);
                before = words[i];
                if (turn == n) {
                    total++;
                    turn = 1;
                } else {
                    turn++;
                }
            }
            return answer;
        }
    }
}
