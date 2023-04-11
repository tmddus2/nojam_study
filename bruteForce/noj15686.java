package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj15686 {
    public static int N, M;
    public static int[][] map;
    public static ArrayList<int[]> chicken;
    public static ArrayList<int[]> home;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        dfs(0,0,new LinkedList<>());
        System.out.println(ans);

    }

    public static void dfs(int index, int num, Queue<int[]> chickens) {
        if (index == chicken.size() || num == M)  {
            if (num != 0) {
                ans = Math.min(ans, calChickenDistance(chickens));
            }
            return;
        }
        Queue<int[]> newChickens1 = new LinkedList<>();
        for(int[] c : chickens) {
            newChickens1.add(c);
        }
        dfs(index+1, num, newChickens1);
        Queue<int[]> newChickens2 = new LinkedList<>();
        for(int[] c : chickens) {
            newChickens2.add(c);
        }
        newChickens2.add(chicken.get(index));
        dfs(index+1, num+1, newChickens2);
    }


    public static int calChickenDistance(Queue<int[]> chickens) {
        int distance = 0;
        for(int[] h : home) {
            int x = h[0];
            int y = h[1];
            int d = N*N;
            for (int[] c : chickens) {
                d = Math.min(d, Math.abs(x-c[0])+Math.abs(y-c[1]));
            }
            if (d != N*N) {
                distance += d;
            }
        }

        return distance;
    }
}
