package programmers;
import java.util.*;

public class 귤_고르기 {
    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            int[] num = new int[10000001];
            for(int i=0; i<tangerine.length; i++) {
                num[tangerine[i]]++;
            }
            Arrays.sort(num);

            for(int i=num.length-1; i>0; i--) {
                if (num[i]==0) {
                    break;
                }
                if (num[i] >= k) {
                    answer++;
                    break;
                }
                answer++;
                k -= num[i];
            }

            return answer;
        }
    }
}
