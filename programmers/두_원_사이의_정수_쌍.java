package programmers;
import java.util.*;

public class 두_원_사이의_정수_쌍 {
    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;
            for(int x=1; x<r2; x++) {
                double y1 = Math.sqrt((long)r1*r1-(long)x*x);
                double y2 = Math.sqrt((long)r2*r2-(long)x*x);
                answer += ((long)Math.floor(y2)-(long)Math.ceil(y1)+1);
            }
            return answer*4+4;
        }

    }
}
