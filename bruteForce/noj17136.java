package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj17136 {
    public static int[][] map = new int[10][10];
    public static boolean[][] visited = new boolean[10][10];
    public static LinkedList<int[]> queue = new LinkedList();
    public static int num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                int t  = Integer.parseInt(st.nextToken());
                map[i][j] = t;
                if (t==1) {
                    queue.add(new int[]{i,j});
                    num++;
                }

            }
        }

        //int ans = bfs();
        if (num != 0) {
            System.out.println("num = " + num);
            System.out.println(-1);
        } else {
            //System.out.println(ans);
        }
    }

    public static void dfs(int x, int y, int dep) {

    }

    public static boolean maxSquare(int x, int y, int size) {
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if (!(i>=0 && i<10 && j>=0 && j<10 && map[i][j]==1 && visited[i][j]==false)) {
                    return false;
                }
            }
        }
        return true;
    }

}
