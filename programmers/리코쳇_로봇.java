package programmers;
import java.util.*;
public class 리코쳇_로봇 {
    class Solution {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        public int solution(String[] board) {
            int answer = 0;
            int startX = 0;
            int startY = 0;
            int endX = 0;
            int endY = 0;
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[i].length(); j++) {
                    if (board[i].charAt(j)=='R') {
                        startX = i;
                        startY = j;
                    }
                    if (board[i].charAt(j)=='G') {
                        endX = i;
                        endY = j;
                    }
                }
            }

            boolean[][] visited = new boolean[board.length][board[0].length()];
            visited[startX][startY] = true;

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startX, startY, 0});

            while(!queue.isEmpty()) {
                int[] q = queue.poll();
                int x = q[0];
                int y = q[1];
                int depth = q[2];

                if (x==endX && y==endY) {
                    answer = depth;
                    break;
                }

                for(int i=0; i<4; i++) {
                    int[] position = move(x, y, board, i);
                    int newX = position[0];
                    int newY = position[1];
                    if (newX>=0 && newX<board.length && newY>=0 && newY<board[0].length() && board[newX].charAt(newY)!='D' && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY, depth+1});
                    }
                }
            }

            if (answer == 0) {
                return -1;
            }
            return answer;
        }

        public int[] move(int x, int y, String[] board, int i) {
            int finalX = x;
            int finalY = y;

            while(true) {
                int tempX = finalX+dx[i];
                int tempY = finalY+dy[i];
                if (tempX>=0 && tempX<board.length && tempY>=0 && tempY<board[0].length() && board[tempX].charAt(tempY) != 'D') {
                    finalX = tempX;
                    finalY = tempY;
                    continue;
                }
                return new int[]{finalX, finalY};
            }
        }
    }
}
