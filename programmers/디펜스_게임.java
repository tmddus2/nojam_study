package programmers;
import java.util.*;

public class 디펜스_게임 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = enemy.length;
            Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0; i<enemy.length; i++) {
                n -= enemy[i];
                priorityQueue.add(enemy[i]);

                if (n<0) {
                    if (k>0) {
                        k--;
                        n += priorityQueue.poll();
                        continue;
                    } else if (k==0) {
                        answer = i;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
