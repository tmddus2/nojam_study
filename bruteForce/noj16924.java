package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// sh0402561!S sh040256!S
public class noj16924 {
    public static int N,M;
    public static char[][] map;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[][] visited;
    public static int num;
    public static LinkedList<int[]> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        ans = new LinkedList<>();
        Queue<Integer[]> queue = new LinkedList<>();

        map = new char[N][M];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++) {
                if (map[i][j]=='*') {
                    queue.add(new Integer[]{i,j});
                }
            }
        }

        num = queue.size();


        while(!queue.isEmpty()) {
            Integer[] t = queue.poll();
            int x = t[0];
            int y = t[1];
            if (visited[x][y] == false) {
                check(x,y);
            }
        }
        System.out.println("num = " + num);
        if (num >= 0) {
            System.out.println(-1);
        } else {
            for(int[] a : ans) {
                System.out.print(a[0]+" "+a[1]+" "+a[2]);
            }
            System.out.println();
        }

    }

    public static void check(int startX, int startY) {
        int size = 1;
        boolean f = false;
        for(int i=1; i<=size; i++) {
            for(int j=0; j<4; j++) {
                int newX = startX+dx[j];
                int newY = startY+dy[j];
                if (!(newX>=0 && newX<N && newY>=0 && newY<M)) {
                    f = true;
                    size -= 1;
                    break;
                }
            }
            if (f) {
                break;
            }
        }
        ans.add(new int[]{startX,startY,size});
        for(int i=1; i<=size; i++) {
            for(int j=0; j<4; j++) {
                int newX = startX+dx[j];
                int newY = startY+dy[j];
                if (newX>=0 && newX<N && newY>=0 && newY<M) {
                    if (visited[newX][newY] == false) {
                        num -= 1;
                    }
                    visited[newX][newY] = true;
                }
            }
        }

        if (visited[startX][startY] == false) {
            num -= 1;
        }
        visited[startX][startY] = true;
    }
}
