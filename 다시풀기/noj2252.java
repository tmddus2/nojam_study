package 다시풀기;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬 알고리즘
// BufferedWriter 사용해서 출력하는 법 익히기
public class noj2252 {
    public static int N;
    public static int M;
    public static int[] edgeCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgeCount = new int[N+1];
        for (int i=0; i<N+1; i++) {
            edgeCount[i] = 0;
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            edgeCount[b]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<N+1; i++) {
            if (edgeCount[i] == 0) {
                queue.add(i);
                bw.write(String.valueOf(i)+" ");
                edgeCount[i]--;
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for(int i=0; i<graph.get(poll).size(); i++) {
                int edge = graph.get(poll).get(i);
                edgeCount[edge]--;
                if (edgeCount[edge]==0) {
                    queue.add(edge);
                    bw.write(String.valueOf(edge)+" ");
                    edgeCount[edge]--;
                }
            }
        }

        bw.flush();
    }
}