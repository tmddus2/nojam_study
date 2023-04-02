package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj4179 {
    static int R;
    static int C;
    static char[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int Jx, Jy, Fx, Fy;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if (map[i][j] == 'J') {
                    Jx = i;
                    Jy = j;
                }
                if (map[i][j] == 'C') {
                    Fx = i;
                    Fy = j;
                }
            }
        }




    }

    public static void dfs(int cntX, int cntY, int time) {
        if(cntX == R-1 || cntY == C-1) {
            if (ans == -1) {
                ans = time;
            } else {
                ans = Math.min(ans, time);
            }
        }
        for (int i=0; i<4; i++) {
            int newJx = cntX + dx[i];
            int newJy = cntY + dy[i];
            if(0<=newJx && newJx<R && 0<=newJy && newJy<C) {
                if(map[newJx][newJy] == '.') {
                    
                }
            }
        }

    }
}
