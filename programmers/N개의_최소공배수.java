package programmers;
import java.util.*;

public class N개의_최소공배수 {
    class Solution {
        public int solution(int[] arr) {
            int answer = 0;
            Arrays.sort(arr);
            answer = arr[arr.length-1];
            while(true) {
                boolean done = true;
                for(int i=0; i<arr.length-1; i++) {
                    if (answer%arr[i] != 0) {
                        answer += arr[arr.length-1];
                        done = false;
                        break;
                    }
                }
                if (done) {
                    break;
                }
            }
            return answer;
        }
    }
}
