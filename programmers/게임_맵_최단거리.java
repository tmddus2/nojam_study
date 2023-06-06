package programmers;
import java.util.*;

public class 게임_맵_최단거리 {
    class Solution {
        public int solution(int[][] maps) {
            int answer = 0;
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0,1});

            while (!queue.isEmpty()) {
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];
                int box = position[2];

                if (box > maps.length*maps[0].length) {
                    break;
                }
                if (x==maps.length-1 && y==maps[0].length-1) {
                    answer = box;
                    break;
                }
                for(int i=0; i<4; i++) {
                    int newX = x+dx[i];
                    int newY = y+dy[i];
                    if (newX>=0 && newX<maps.length && newY>=0 && newY<maps[0].length && maps[newX][newY] == 1) {
                        queue.add(new int[]{newX, newY, box+1});
                        maps[newX][newY] = 0;
                    }
                }
            }
            if (answer == 0) {
                return -1;
            }
            return answer;
        }
    }
}
