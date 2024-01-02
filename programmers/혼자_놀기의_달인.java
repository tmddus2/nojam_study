package programmers;
import java.util.*;

public class 혼자_놀기의_달인 {
    class Solution {
        public int solution(int[] cards) {
            int answer = 0;
            ArrayList<Integer> result = play(cards);

            if (result.size() == cards.length) {
                return 0;
            }

            for(int r : result) {
                cards[r] = -1;
            }
            answer = result.size();

            result = play(cards);
            answer *= result.size();

            return answer;
        }

        public ArrayList<Integer> play(int[] cards) {
            int box = 0;
            ArrayList<Integer> boxList = new ArrayList<>();
            boolean[] visited = new boolean[cards.length];
            for(int i=0; i<cards.length; i++) {
                if (visited[i] || cards[i]==-1) {
                    continue;
                }

                int start = i;
                ArrayList<Integer> arr = new ArrayList<>();

                while (!visited[start] && cards[start]!=-1) {
                    int newStart = cards[start]-1;
                    arr.add(newStart);
                    visited[start] = true;
                    start = newStart;
                }

                if (boxList.size() < arr.size()) {
                    box = start;
                    boxList = arr;
                }
            }

            return boxList;
        }
    }
}
