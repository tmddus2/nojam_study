package programmers;
import java.util.*;

public class 더_맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i=0; i<scoville.length; i++) {
                queue.add(scoville[i]);
            }
            int food = queue.poll();
            while(!queue.isEmpty()) {
                if (food < K) {
                    int newFood = queue.poll();
                    food = food+newFood*2;
                    answer++;
                    queue.add(food);
                    food = queue.poll();
                } else {
                    queue.add(food);
                    food = queue.poll();
                    if (food >= K) {
                        break;
                    }
                }
            }
            if (food < K) {
                return -1;
            }
            return answer;
        }
    }
}
