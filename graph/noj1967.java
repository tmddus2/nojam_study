package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class noj1967 {
    static int N;
    static ArrayList<Node>tree[];
    static boolean[] visited;
    static int max = 0;
    static int max_idx = 0;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[node1].add(new Node(node2, weight));
            tree[node2].add(new Node(node1, weight));
        }
        /*
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1,0);
        System.out.println("max_idx = " + max_idx);
        System.out.println("max = " + max);

        visited = new boolean[N+1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);
        */

        ans = 0;
        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(ans);

    }

    public static void dfs(int idx, int cnt) {
        if(ans < cnt) {
            ans = cnt;
        }

        for(Node a : tree[idx]) {
            if(!visited[a.idx]) {
                visited[a.idx] = true;
                dfs(a.idx, cnt+a.cnt);
            }
        }
    }

    static class Node {
        int idx, cnt;
        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

}
