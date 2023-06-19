package programmers;
import java.util.*;

public class 무인도_여행 {
    class Solution {
        public char[][] m;
        public boolean[][] visited;
        public int[] dx = {0,0,1,-1};
        public int[] dy = {1,-1,0,0};
        public int[] solution(String[] maps) {
            int[] answer = {};
            visited = new boolean[maps.length][maps[0].length()];
            m = new char[maps.length][maps[0].length()];
            for(int i=0; i<m.length; i++) {
                m[i] = maps[i].toCharArray();
            }
            ArrayList<Integer> result = new ArrayList<>();
            for(int i=0; i<m.length; i++) {
                for(int j=0; j<m[0].length; j++) {
                    if (m[i][j]!='X' && !visited[i][j]) {
                        result.add(count(i,j));
                    }
                }
            }

            answer = new int[result.size()];
            for(int i=0; i<result.size(); i++) {
                answer[i] = result.get(i);
            }
            if (answer.length == 0) {
                return new int[]{-1};
            }
            Arrays.sort(answer);
            return answer;
        }

        public int count(int x, int y) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x,y});
            int ans = (int)m[x][y]-48;
            visited[x][y] = true;

            while(!queue.isEmpty()) {
                int[] pos = queue.poll();
                int X = pos[0];
                int Y = pos[1];
                for(int i=0; i<4; i++) {
                    int newX = X+dx[i];
                    int newY = Y+dy[i];
                    if (newX>=0 && newX<m.length && newY>=0 && newY<m[0].length) {
                        if (!visited[newX][newY] && m[newX][newY]!='X') {
                            ans += ((int)(m[newX][newY])-48);
                            visited[newX][newY] = true;
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }

            return ans;
        }
    }
}
