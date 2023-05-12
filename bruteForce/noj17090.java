package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj17090 {
    public static int N, M;
    public static char[][] map;
    public static int[] dx = {-1,0,1,0}; // U R D L
    public static int[] dy = {0,1,0,-1};
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (map[i][j] == 'T') {
                    ans++;
                } else {
                    if (check(i,j)) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean check(int x, int y){
        if (x<0 || x>=N || y<0 || y>=M) {
            return true;
        }
        if (map[x][y] == 'T') {
            return true;
        } else if (map[x][y] == 'F') {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;

        int newX = x;
        int newY = y;
        if (map[newX][newY] == 'U') {
            newX += dx[0];
            newY += dy[0];
        } else if (map[newX][newY] == 'R') {
            newX += dx[1];
            newY += dy[1];
        } else if (map[newX][newY] == 'D') {
            newX += dx[2];
            newY += dy[2];
        } else if (map[newX][newY] == 'L') {
            newX += dx[3];
            newY += dy[3];
        }

        if (check(newX, newY)) {
            map[x][y] = 'T';
            return true;
        } else {
            map[x][y] = 'F';
            return false;
        }
    }

}
