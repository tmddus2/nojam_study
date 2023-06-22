package programmers;
import java.util.*;

public class 전력망을_둘로_나누기 {
    class Solution {
        public boolean[][] connected;
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            connected = new boolean[n+1][n+1];
            for(int i=0; i<wires.length; i++) {
                int n1= wires[i][0];
                int n2= wires[i][1];
                connected[n1][n2] = true;
                connected[n2][n1] = true;
            }

            for(int i=0; i<wires.length; i++) {
                // 하나씩 돌아가면서 끊어감
                int n1= wires[i][0];
                int n2= wires[i][1];
                connected[n1][n2] = false;
                answer = Math.min(answer, checkGap(n));
                connected[n1][n2] = true;
            }

            return answer;
        }

        public int checkGap(int n) {
            boolean[] visited = new boolean[n+1];
            int group1 = 0;
            int group2 = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            while(!queue.isEmpty()) {
                Integer node = queue.poll();
                visited[node] = true;
                group1++;
                for(int i=1; i<connected[node].length; i++) {
                    if (node >= i) {
                        if (connected[i][node]) {
                            if (!visited[i]) {
                                queue.add(i);
                            }
                        }
                    } else {
                        if (connected[node][i]) {
                            if (!visited[i]) {
                                queue.add(i);
                            }
                        }
                    }
                }
            }

            int newStart = 0;
            for(int i=1; i<visited.length; i++) {
                if (!visited[i]) {
                    newStart = i;
                    break;
                }
            }
            queue.add(newStart);
            while(!queue.isEmpty()) {
                Integer node = queue.poll();
                visited[node] = true;
                group2++;
                for(int i=1; i<connected[node].length; i++) {
                    if (node >= i) {
                        if (connected[i][node]) {
                            if (!visited[i]) {
                                queue.add(i);
                            }
                        }
                    } else {
                        if (connected[node][i]) {
                            if (!visited[i]) {
                                queue.add(i);
                            }
                        }
                    }
                }
            }

            return Math.abs(group1-group2);
        }
    }
}
