package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj16958 {
    public static int N, T;
    public static int[][] city;
    public static boolean[] isSpecial;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        city = new int[N+1][2];
        isSpecial = new boolean[N+1];
        for (int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                isSpecial[i] = true;
            }
            city[i][0] = Integer.parseInt(st.nextToken());
            city[i][1] = Integer.parseInt(st.nextToken());
        }


        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(bfs(city[A][0],city[A][1],city[B][0],city[B][1]));
        }
    }

    public static int getDistance(int r1, int c1, int r2, int c2) {
        boolean special1 = false;
        boolean special2 = false;

        for (int i=1; i<isSpecial.length; i++) {
            if (city[i][0]==r1 && city[i][1]==c1 && isSpecial[i]) {
                special1 = true;
            } else if (city[i][0]==r2 && city[i][1]==c2 && isSpecial[i]) {
                special2 = true;
            }
        }

        if (special1 && special2) {
            return Math.min(T, Math.abs(r1-r2)+Math.abs(c1-c2));
        }

        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }

    public static int bfs(int Ax, int Ay, int Bx, int By) {
        int ans = getDistance(Ax, Ay, Bx, By);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{Ax, Ay, 0});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int time = poll[2];
            if (x==Bx && y==By) {
                continue;
            }
            ans = Math.min(ans, time+getDistance(x,y,Bx,By));
            for(int i=1; i<city.length; i++) {
                int newX = city[i][0];
                int newY = city[i][1];
                int newTime = time+getDistance(x,y,newX,newY);
                if (newTime < ans) {
                    if (x==newX && y==newY) {
                        continue;
                    }
                    queue.add(new int[]{newX, newY, newTime});
                }
            }
        }

        return ans;
    }
}
