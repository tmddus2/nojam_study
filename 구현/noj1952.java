package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj1952 {
    public static int N;
    public static int M;
    public static int[] dirX = {0,1,0,-1};
    public static int[] dirY = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(snail());
    }

    public static int snail() {
        int x = 0;
        int y = 0;
        int dir = 0;
        boolean[][] visited = new boolean[N][M];
        int ans = 0;
        for(int i=0; i<N*M; i++) {
            if (i == N*M-1) {
                continue;
            }
            visited[x][y] = true;
            int newX = x+dirX[dir];
            int newY = y+dirY[dir];
            if (newX<0 || newX>=N || newY<0 || newY>=M || visited[newX][newY] == true) {
                dir = (dir+1) % 4;
                System.out.println("newX = " + newX+", newY = " + newY);
                ans += 1;
                x = x+dirX[dir];
                y = y+dirY[dir];
            } else {
                x = newX;
                y = newY;
            }
        }
        return ans;

    }
}
