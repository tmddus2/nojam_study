package programmers;
import java.util.*;

public class n2_배열_자르기 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = {};
            answer = new int[(int)(right-left+1)];
            for(int i=0; i<answer.length; i++) {
                long index = left+i;
                int row = (int)(index/n);
                int col = (int)(index%n);


                if (col <= row) {
                    answer[i] = row+1;
                } else {
                    answer[i] = col+1;
                }

            }
            return answer;
        }
    }
}
