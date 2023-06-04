package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj14503 {
    public static int N, M;
    public static int[][] map;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, dir});
        int result = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int direction = poll[2];
            System.out.print("x = " + x);
            System.out.print(", y = " + y);
            System.out.print(", direction = " + direction);
            System.out.println(", map[x][y] = " + map[x][y]);
            if (map[x][y] == 0) {
                result++;
                map[x][y] = 2; // 청소 완료
            }

            boolean stop1 = false;
            int newDir = direction;
            for(int i=0; i<4; i++) {
                newDir = (newDir+3)%4;
                int newX = x+dx[newDir];
                int newY = y+dy[newDir];
                if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY]==0) {
                    queue.add(new int[]{newX, newY, newDir});
                    stop1 = true;
                    break;
                }
            }
            if (stop1) {
                continue;
            }

            boolean stop = false;
            newDir = (direction+2)%4;
            int newX = x+dx[newDir];
            int newY = x+dy[newDir];
            if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY]!=1) {
                queue.add(new int[]{newX, newY, newDir});
            }
            else if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY]==1) {
                stop = true;
                break;
            }

            if (stop) {
                break;
            }
        }

        System.out.println(result);
    }
}
