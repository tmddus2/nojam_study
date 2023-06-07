package programmers;
import java.util.*;

public class 방문_길이 {
    class Solution {
        public int solution(String dirs) {
            int answer = 0;
            int[] dx = {-1,1,0,0}; // U, D, R, L
            int[] dy = {0,0,1,-1};
            HashMap<String, Integer> visited = new HashMap<>();
            int x = 0;
            int y = 0;
            for(int i=0; i<dirs.length(); i++) {
                char letter = dirs.charAt(i);
                int nextX = x;
                int nextY = y;
                if (letter == 'U') {
                    nextX += dx[0];
                    if (nextX>5 || nextX<-5) {
                        continue;
                    }
                } else if (letter == 'D') {
                    nextX += dx[1];
                    if (nextX>5 || nextX<-5) {
                        continue;
                    }
                } else if (letter == 'R') {
                    nextY += dy[2];
                    if (nextY>5 || nextY<-5) {
                        continue;
                    }
                } else if (letter == 'L') {
                    nextY += dy[3];
                    if (nextY>5 || nextY<-5) {
                        continue;
                    }
                }

                String path = getPath(x,y,nextX,nextY);
                if (!visited.containsKey(path)) {
                    answer++;
                    visited.put(path, 0);
                }
                x = nextX;
                y = nextY;
            }
            return answer;
        }

        public String getPath(int x1, int y1, int x2, int y2) {
            if (x1 == x2) { // 세로선
                if (y1 > y2) {
                    return String.valueOf(x1)+String.valueOf(y1)+String.valueOf(x2)+String.valueOf(y2);
                } else {
                    return String.valueOf(x2)+String.valueOf(y2)+String.valueOf(x1)+String.valueOf(y1);
                }
            }
            if (y1 == y2) { // 가로선
                if (x1 > x2) {
                    return String.valueOf(x2)+String.valueOf(y2)+String.valueOf(x1)+String.valueOf(y1);
                } else {
                    return String.valueOf(x1)+String.valueOf(y1)+String.valueOf(x2)+String.valueOf(y2);
                }
            }
            return "";
        }
    }
}
