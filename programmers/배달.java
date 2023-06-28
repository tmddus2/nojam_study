package programmers;

public class 배달 {
    class Solution {
        public int[] dist;
        public boolean[] visited;
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            dist = new int[N+1];
            visited = new boolean[N+1];
            for(int i=2; i<N+1; i++) {
                dist[i] = Integer.MAX_VALUE;
            }

            int count = 0;
            int node = 1;

            while(count != N) {
                for(int i=0; i<road.length; i++) {
                    int a = road[i][0];
                    int b = road[i][1];
                    int c = road[i][2];

                    if (a == node) {
                        dist[b] = Math.min(dist[b], dist[a]+c);
                    } else if (b == node) {
                        dist[a] = Math.min(dist[a], dist[b]+c);
                    }
                }
                visited[node] = true;
                node = getNextNode();
                count++;
            }

            for(int i=1; i<N+1; i++) {
                if (dist[i] <= K) {
                    answer++;
                }
            }

            return answer;
        }

        public int getNextNode() {
            int idx = 1;
            int value = Integer.MAX_VALUE;

            for(int i=2; i<dist.length; i++) {
                if (!visited[i] && dist[i] < value) {
                    idx = i;
                    value = dist[i];
                }
            }
            return idx;
        }
    }
}
