package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj1325 {
    static int N;
    static int M;
    static ArrayList<Integer>node[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        node = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            node[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            node[B].add(A);
        }
        int maxN = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1; i<N+1; i++) {
            int temp = bfs(i);
            if (temp > maxN) {
                maxN = temp;
                result = new ArrayList<>();
                result.add(i);
            } else if (temp == maxN) {
                result.add(i);
            }
        }

        for(int r : result) {
            System.out.print(r + " ");
        }
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        int ans = 0;
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            for(int c : node[poll]) {
                if(visited[c] == false) {
                    visited[c] = true;
                    queue.add(c);
                    ans += 1;
                }
            }
        }
        return ans;

    }
}
