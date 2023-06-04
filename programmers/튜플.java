package programmers;
import java.util.*;

public class 튜플 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = {};
            String tuples = s.substring(2, s.length()-2);
            String[] t = tuples.split("\\D,\\D");
            Arrays.sort(t, (String s1, String s2) -> s1.length()-s2.length());
            answer = new int[t.length];
            boolean[] visited = new boolean[1000000];
            for(int i=0; i<t.length; i++) {
                String[] set = t[i].split(",");
                for(int j=0; j<set.length; j++) {
                    int temp = Integer.valueOf(set[j]);
                    if (!visited[temp]) {
                        answer[i] = temp;
                        visited[temp] = true;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
