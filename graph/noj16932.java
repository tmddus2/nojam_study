package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class noj16932 {
    static int[][] map;
    static int N;
    static int M;
    static int size;
    static boolean[][] visited;
    static Queue<int[]> zero;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tt = br.readLine().split(" ");
        N = Integer.parseInt(tt[0]);
        M = Integer.parseInt(tt[1]);
        map = new int[N][M];

        zero = new LinkedList<>();
        for (int i=0; i<N; i++) {
            String[] t = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                int v = Integer.parseInt(t[j]);
                map[i][j] = v;
                if (v == 0) {
                    zero.add(new int[]{i, j});
                }
            }
        }

        System.out.println(getMaxSize());


    }

    public static int getMaxSize() {
        int ans = -1;
        while(!zero.isEmpty()) {
            int[] p = zero.poll();
            int a = p[0];
            int b = p[1];

            if (map[a][b] == 0) {
                visited = new boolean[N][M];
                size = 1;

                visited[a][b] = true;
                map[a][b] = 1;

                getSize(a,b);

                ans = Math.max(ans, size);
                visited[a][b] = false;
                map[a][b] = 0;
            }
        }

        return ans;
    }

    public static void getSize(int x, int y) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i=0; i<4; i++) {
            int newX = x+dx[i];
            int newY = y+dy[i];
            if (0<=newX && newX<N && 0<=newY && newY<M) {
                if (visited[newX][newY] == false && map[newX][newY] == 1) {
                    size += 1;
                    visited[newX][newY] = true;
                    getSize(newX, newY);

                }

            }
        }


    }
}
