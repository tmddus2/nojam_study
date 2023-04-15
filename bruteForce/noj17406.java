package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class noj17406 {
    public static int N, M, K;
    public static int[][] A;
    public static int[] r;
    public static int[] c;
    public static int[] s;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        r = new int[K];
        c = new int[K];
        s = new int[K];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }



        dfs(0, A, new boolean[K]);
        System.out.println(ans);
    }

    public static int[][] turn(int[][] a, int r, int c, int s) {
        int[][] b = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                b[i][j] = a[i][j];
            }
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int length = 2*s+1;
        int x = r-s-2;
        int y = c-s-2;
        for(int i=s ; i>0; i--) {
            x++;
            y++;
            int tx = x;
            int ty = y;
            int count = 0;
            int rotation = 0;
            for(int j=0 ; j<(length-1)*4 ; j++) {
                b[tx+dx[rotation]][ty+dy[rotation]] = a[tx][ty];
                tx = tx+dx[rotation];
                ty = ty+dy[rotation];
                count++;
                if (count == length-1) {
                    count=0;
                    rotation++;
                }
            }
            length = length-2;

        }
        return b;
    }

    public static int returnArrValue(int[][] a) {
        int num = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            int t = 0;
            for(int j=0; j<M; j++) {
                t += a[i][j];
            }
            num = Math.min(num, t);
        }
        return num;
    }

    public static void dfs(int num, int[][] a, boolean[] visited) {
        if (num==K) {
            ans = Math.min(ans, returnArrValue(a));
            return;
        }
        for(int i=0; i< visited.length; i++) {
            if (visited[i] == false) {
                int[][] turn = turn(a, r[i], c[i], s[i]);
                visited[i] = true;
                dfs(num+1, turn, visited);
                visited[i] = false;
            }
        }

    }

}
