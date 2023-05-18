package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj2573 {
    public static int[][] map;
    public static int N,M;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int num = 0;
    public static Queue<int[]> ices = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int t = Integer.parseInt(st.nextToken());
                map[i][j] = t;
                if (t != 0) {
                    ices.add(new int[]{i,j});
                }
            }
        }

        System.out.println(bfs());
    }

    public static int checkDivided() {
        int[] peek = ices.peek();
        num = 1;
        boolean[][] visited = new boolean[N][M];
        visited[peek[0]][peek[1]] = true;
        dfs(peek[0], peek[1], visited);

        return num;
    }

    public static void dfs(int x, int y, boolean[][] visited) {
        for(int i=0; i<4; i++) {
            int newX = x+dx[i];
            int newY = y+dy[i];
            if (newX>=0 && newX<N && newY>=0 && newY<M && visited[newX][newY] == false && map[newX][newY] > 0) {
                num++;
                visited[newX][newY] = true;
                dfs(newX, newY, visited);
            }
        }
    }

    public static int bfs() {
        int day = 0;
        while(!ices.isEmpty()) {
            int size = ices.size();
            day++;

            boolean[][] visited = new boolean[N][M];
            for(int i=0; i<size; i++) {
                int[] poll = ices.poll();
                int x = poll[0];
                int y = poll[1];
                int surroundNum = 0;
                for (int j=0; j<4; j++) {
                    int newX = x+dx[j];
                    int newY = y+dy[j];
                    if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY]==0 && visited[newX][newY]==false) {
                        surroundNum++;
                    }
                }
                map[x][y] -= surroundNum;
                if (map[x][y] <= 0) {
                    map[x][y] = 0;
                    visited[x][y] = true;
                } else {
                    ices.add(new int[]{x,y});
                }
            }

            if (!ices.isEmpty()) {
                checkDivided();
                if (num < ices.size()) {
                    return day;
                }
            }
        }
        return 0;
    }
}
