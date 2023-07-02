package programmers;

import java.util.*;
public class 거리두기_확인하기 {
    class Solution {
        public int[] dx = {0,0,1,-1};
        public int[] dy = {1,-1,0,0};
        public int[] solution(String[][] places) {
            int[] answer = new int[5];
            for(int i=0; i<5; i++) {
                char[][] charPlaces = new char[5][5];
                for(int j=0; j<5; j++) {
                    charPlaces[j] = places[i][j].toCharArray();
                }
                int result = 1;
                for(int j=0; j<5; j++) {
                    for(int k=0; k<5; k++) {
                        if (charPlaces[j][k] == 'P') {
                            if (!bfs(j,k,charPlaces)) {
                                result = 0;
                                break;
                            }
                        }
                    }
                    if (result == 0) {
                        break;
                    }
                }
                answer[i] = result;
            }
            return answer;
        }

        public boolean bfs(int x, int y, char[][] places) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x,y});

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                int curX = poll[0];
                int curY = poll[1];

                for(int i=0; i<4; i++) {
                    int newX = curX+dx[i];
                    int newY = curY+dy[i];
                    if (newX == x && newY == y) {
                        continue;
                    }
                    if (newX>=0 && newX<5 && newY>=0 && newY<5) {
                        if (getDistance(x,y,newX,newY) <= 2 && places[newX][newY] == 'P') {
                            return false;
                        } else if (getDistance(x,y,newX,newY) < 2 && places[newX][newY] == 'O') {
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
            return true;
        }

        public int getDistance(int x1, int y1, int x2, int y2) {
            return Math.abs(x1-x2) + Math.abs(y1-y2);
        }
    }
}
