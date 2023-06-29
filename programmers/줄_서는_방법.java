package programmers;
import java.util.*;

public class 줄_서는_방법 {
    class Solution {
        public int[] solution(int n, long k) {
            int[] answer = new int[n];
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=1; i<=n; i++) {
                arr.add(i);
            }

            int index = 0;
            int digit = n-1;
            long count = 1;
            for(int i=1; i<n; i++) {
                count *= i;
            }
            while(index != n-1) {
                int idx = (int)(((k-1)/count) % arr.size());
                answer[index] = arr.get(idx);
                arr.remove(idx);

                count /= digit;
                index++;
                digit--;
            }

            answer[n-1] = arr.get(0);
            return answer;
        }
    }
}
