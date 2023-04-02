package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj1260 {
    public static int N;
    public static int M;
    public static int V;
    public static ArrayList<Integer>map[];
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            map[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first].add(second);
            map[second].add(first);
        }

        dfs(V);
        System.out.println();
        bfs();
    }

    public static void dfs(int node) {
        if (visited[node] == true) {
            return;
        }
        boolean[] isConnected = new boolean[N+1];
        for(int n : map[node]) {
            isConnected[n] = true;
        }
        System.out.print(node+" ");
        visited[node] = true;
        for(int i=1; i<N+1; i++) {
            if(isConnected[i]==true && visited[i]==false) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        boolean[] visited = new boolean[N+1];
        visited[V] = true;
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            boolean[] isConnected = new boolean[N+1];
            for(int n : map[node]) {
                isConnected[n] = true;
            }
            System.out.print(node+" ");
            for(int i=1; i<N+1; i++) {
                if(isConnected[i]==true && visited[i]==false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
