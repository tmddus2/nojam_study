package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj17471 {
    public static int N;
    public static int[] people;
    public static boolean[][] connected;
    public static boolean[] picked;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        connected = new boolean[N+1][N+1];
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++) {
                connected[i][Integer.parseInt(st.nextToken())] = true;
            }
        }


        for(int i=1; i<N; i++) {
            picked = new boolean[N+1];
            pickArea(0, new int[i], i,0);
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static int gap(int[] a, int[] b) {
        int sumA = 0;
        int sumB = 0;
        for(int aa : a) {
            sumA += people[aa];
        }
        for(int bb : b) {
            sumB += people[bb];
        }
        return Math.abs(sumA-sumB);
    }

    public static boolean isConnected(int[] area) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(area[0]);
        visited[area[0]] = true;
        while (!queue.isEmpty()) {
            Integer a = queue.poll();
            for(int i=1; i<N+1; i++) {
                if (connected[a][i]) {
                    boolean check = false;
                    for(int j=0; j<area.length; j++) {
                        if (a.equals(area[j])) {
                            check = true;
                            break;
                        }
                    }
                    if (check==true && visited[i]==false) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }

        for(int aa : area) {
            if (visited[aa]==false) {
                return false;
            }
        }

        return true;

    }

    public static void pickArea(int idx, int[] pick, int size, int last) {
        if (idx == size) {
            int[] notPicked = new int[N-pick.length];
            int index = 0;
            for(int i=1; i<N+1; i++) {
                boolean check = false;
                for(int j=0; j<pick.length; j++) {
                    if (i == pick[j]) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    notPicked[index] = i;
                    index++;
                }
            }

            if (isConnected(pick) && isConnected(notPicked)) {
                ans = Math.min(ans, gap(pick, notPicked));
            }
            return;
        }
        for(int i=last+1; i<N+1; i++) {
            if (!picked[i]) {
                int[] copy = new int[size];
                for(int j=0; j<pick.length; j++) {
                    copy[j] = pick[j];
                }
                copy[idx] = i;
                picked[i] = true;
                pickArea(idx+1, copy, size, i);
                picked[i] = false;
            }
        }

    }
}
