package programmers;
import java.util.*;

public class 다리를_지나는_트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<bridge_length-1; i++) {
                queue.add(0);
            }
            queue.add(truck_weights[0]);
            answer++;
            int sum = truck_weights[0];
            int num = 1;

            for(int i=1; i<truck_weights.length; i++) {
                if (sum+truck_weights[i]<=weight) {
                    if (queue.size() < bridge_length) {
                        queue.add(truck_weights[i]);
                        sum += truck_weights[i];
                        answer++;
                        num++;
                    } else if (queue.size() == bridge_length) {
                        if (queue.peek() != 0) {
                            num--;
                        }
                        queue.add(truck_weights[i]);
                        sum -= queue.poll();
                        sum += truck_weights[i];
                        answer++;
                        num++;
                    }
                } else {
                    while(!(sum+truck_weights[i] <= weight && num <= bridge_length)) {
                        if (queue.size() < bridge_length) {
                            queue.add(0);
                            answer++;
                        } else if (queue.size() == bridge_length) {
                            if (queue.peek() != 0) {
                                num--;
                            }
                            queue.add(0);
                            sum -= queue.poll();
                            answer++;
                        }
                    }
                    Queue newQueue = new LinkedList<>();
                    while (queue.size() != 1) {
                        newQueue.add(queue.poll());
                    }
                    newQueue.add(truck_weights[i]);
                    queue = newQueue;
                    sum += truck_weights[i];
                }
            }

            if (sum == 0) {
                return answer;
            }
            while(sum != 0) {
                answer++;
                sum -= queue.poll();
            }

            return answer;
        }

    }
}
