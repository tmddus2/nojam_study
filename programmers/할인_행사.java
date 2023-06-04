package programmers;
import java.util.*;

public class 할인_행사 {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            Map<String, Integer> list = new HashMap<>();
            for(int i=0; i<want.length; i++) {
                list.put(want[i], i);
            }

            for(int i=0; i<discount.length-9; i++) {
                int[] checkNum = new int[want.length];

                for(int j=0; j<checkNum.length; j++) {
                    checkNum[j] = 0;
                }

                for(int j=i; j<i+10; j++) {
                    if (list.containsKey(discount[j])) {
                        checkNum[list.get(discount[j])]++;
                    }
                }

                boolean possible = true;
                for(int j=0; j<checkNum.length; j++) {
                    if (checkNum[j] != number[j]) {
                        possible = false;
                    }
                }
                if (possible) {
                    answer++;
                }

            }

            return answer;
        }
    }
}
