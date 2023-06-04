package programmers;
import java.util.*;

public class 프로세스 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            int[] prioritiesNum = new int[10];
            for(int i=0; i<10; i++) {
                prioritiesNum[i] = 0;
            }
            Queue<Integer> queue = new LinkedList<>();
            int maxPriority = 0;
            for(int i=0; i<priorities.length; i++) {
                queue.add(i);
                prioritiesNum[priorities[i]]++;
                if (maxPriority<priorities[i]) {
                    maxPriority = priorities[i];
                }
            }
            int process = location;


            while(true) {
                int p = queue.poll();
                if (priorities[p] < maxPriority) {
                    queue.add(p);
                } else {
                    answer++;
                    if (p==process) {
                        break;
                    }
                    prioritiesNum[maxPriority]--;
                    if (prioritiesNum[maxPriority] == 0) {
                        for(int i=maxPriority; i>=0; i--) {
                            if (prioritiesNum[i] != 0) {
                                maxPriority = i;
                                break;
                            }
                        }
                    }
                }
            }

            return answer;
        }
    }
}
