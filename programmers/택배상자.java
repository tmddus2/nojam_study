package programmers;
import java.util.*;

public class 택배상자 {
    class Solution {
        public int solution(int[] order) {
            int answer = 0;
            Stack<Integer> second = new Stack<>();

            int nowBox = 1;
            for(int i=0; i<order.length; i++) {
                boolean terminate = false;
                while(true) {
                    if (nowBox < order[i]) {
                        second.push(nowBox);
                        nowBox++;
                    } else if (nowBox == order[i]) {
                        answer++;
                        nowBox++;
                        break;
                    } else {
                        if (!second.isEmpty() && second.peek() == order[i]) {
                            answer++;
                            second.pop();
                        } else {
                            terminate = true;
                        }
                        break;
                    }
                }
                if (terminate) {
                    break;
                }
            }
            return answer;
        }
    }
}
