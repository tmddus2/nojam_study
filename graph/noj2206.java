package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj2206 {
    static int N, M;
    static int[][][] visited;
    static char[][] map;
    static int[] dxs = {0,0,1,-1};
    static int[] dys = {1,-1,0,0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M][2];
        for(int[][] i : visited) {
            for(int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        map = new char[N][M];
        for (int i=0; i<N; i++) {
            String t = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = t.charAt(j);
            }
        }

        visited[0][0][0] = 1;
        q.add(new int[]{0,0,0});

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            int wall = t[2];

            for (int i : new int[]{0,1,2,3}) {
                int newX = x+dxs[i];
                int newY = y+dys[i];

                if (0<=newX && newX<N && 0<=newY && newY<M) {
                    if (wall == 0 && map[newX][newY] == '1' && visited[newX][newY][1] == -1) {
                        visited[newX][newY][1] = visited[x][y][0] + 1;
                        q.add(new int[]{newX, newY, 1});
                    } else if (map[newX][newY] == '0' && visited[newX][newY][wall] == -1) {
                        visited[newX][newY][wall] = visited[x][y][wall] + 1;
                        q.add(new int[]{newX, newY, wall});
                    }

                }
            }

        }

        if (visited[N-1][M-1][0] == -1 && visited[N-1][M-1][1] != -1) {
            System.out.println(visited[N-1][M-1][1]);
        } else if (visited[N-1][M-1][0] != -1 && visited[N-1][M-1][1] == -1) {
            System.out.println(visited[N-1][M-1][0]);
        } else {
            System.out.println(Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]));
        }


    }

}
