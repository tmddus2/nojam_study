package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class noj2056 {
    public static int N;
    public static int[] endingTime;
    public static int[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        endingTime = new int[N+1];
        times = new int[N+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=1; i<N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j=0; j<t; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        endingTime[1] = times[1];
        int ans = times[1];
        for(int i=2; i<N+1; i++) {
            ArrayList<Integer> priority = graph.get(i);
            int lastEnding = 0;
            for (int p : priority) {
                if (endingTime[p] > lastEnding) {
                    lastEnding = endingTime[p];
                }
            }
            if (lastEnding == 0) {
                endingTime[i] = times[i];
            } else {
                endingTime[i] = lastEnding+times[i];
            }
            ans = Math.max(endingTime[i], ans);
        }

        System.out.println(ans);

    }
}
