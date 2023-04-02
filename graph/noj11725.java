package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj11725 {
    static int N;
    static ArrayList<Integer>node[];
    static int[] saveNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        node = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            node[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            node[first].add(second);
            node[second].add(first);
        }

        saveNode = new int[N+1];
        bfs();
        for(int i=2; i<N+1; i++) {
            System.out.println(saveNode[i]);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for(int p : node[poll]) {
                if (saveNode[p] == 0){
                    saveNode[p] = poll;
                    queue.add(p);
                }
            }
        }
    }
}
