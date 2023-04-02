package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj1600 {
    public static int[][] map;
    public static int[] dxMonkey = {0,0,1,-1};
    public static int[] dyMonkey = {1,-1,0,0};
    public static int[] dxHorse = {1,1,2,2,-1,-1,-2,-2};
    public static int[] dyHorse = {2,-2,1,-1,2,-2,1,-1};
    public static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][31];
        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,K,0}); // x, y, 남은 K 수, 움직이는 동작
        int ans = -1;
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int k = poll[2];
            int a = poll[3];

            if (x == H-1 && y == W-1) {
                if (ans == -1) {
                    ans = a;
                } else{
                    ans = Math.min(ans, a);
                }
                continue;
            }
            if ( k !=0 ) {
                for(int i=0; i<8; i++) {
                    int newX = x+dxHorse[i];
                    int newY = y+dyHorse[i];
                    if (0<=newX && newX<H && 0<=newY && newY<W) {
                        if (map[newX][newY] == 0 && visited[newX][newY][k-1] == false) {
                            visited[newX][newY][k-1] = true;
                            q.add(new int[]{newX, newY, k-1, a+1});
                        }
                    }
                }
            }

            for(int i=0; i<4; i++) {
                int newX = x+dxMonkey[i];
                int newY = y+dyMonkey[i];
                if (0<=newX && newX<H && 0<=newY && newY<W) {
                    if(map[newX][newY] == 0 && visited[newX][newY][k] == false) {
                        visited[newX][newY][k] = true;
                        q.add(new int[]{newX, newY, k, a+1});
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
