package programmers;
import java.util.*;

public class 기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            int[] days = new int[progresses.length];

            for(int i=0; i<progresses.length; i++) {
                if ((100-progresses[i])%speeds[i] == 0) {
                    days[i] = (100-progresses[i])/speeds[i];
                } else {
                    days[i] = (100-progresses[i])/speeds[i]+1;
                }
            }

            ArrayList<Integer> release = new ArrayList<>();
            int d = days[0];
            int num = 0;
            for(int i=0; i<days.length; i++) {
                if (days[i] <= d) {
                    num++;
                } else {
                    release.add(num);
                    num = 1;
                    d = days[i];
                }
            }

            if (num != 0) {
                release.add(num);
            }

            answer = new int[release.size()];
            for(int i=0; i<answer.length; i++) {
                answer[i] = release.get(i);
            }

            return answer;
        }
    }
}
