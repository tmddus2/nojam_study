package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class noj17281 {
    public static int N;
    public static int[][] scores;
    public static boolean[] visited = new boolean[10];
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N+1][10];

        for(int i=1; i<N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] p = new int[10];
        p[4] = 1;
        visited[1] = true;
        dfs(1, p);

        System.out.println(ans);

    }

    public static void dfs(int num, int[] players) {
        if (num == 10) {
            playGame(players);
        }
        if (num==4) {
            num++;
        }
        for(int i=2; i<visited.length; i++) {
            if (visited[i] == false) {
                players[num] = i;
                visited[i] = true;
                dfs(num+1, players);
                visited[i] = false;
            }
        }

    }

    public static void playGame(int[] players) {
        int out = 0;
        int inning = 1;
        int playerIndex = 1; // index
        int score = 0;

        while (inning != N+1) {
            out = 0;
            boolean first = false;
            boolean second = false;
            boolean third = false;
            while(out != 3) {
                int player = players[playerIndex];
                int hit = scores[inning][player];
                if (hit == 0) {
                    out++;
                } else if (hit == 1) {
                    if (third) {
                        score++;
                    }
                    third = second;
                    second = first;
                    first = true;
                } else if (hit == 2) {
                    if (third) {
                        score++;
                    }
                    if(second) {
                        score++;
                    }
                    third = first;
                    second = true;
                    first = false;
                } else if (hit == 3) {
                    if (third) {
                        score++;
                    }
                    if(second) {
                        score++;
                    }
                    if(first) {
                        score++;
                    }
                    first = false;
                    second = false;
                    third = true;
                } else if (hit == 4) {
                    if (third) {
                        score++;
                    }
                    if(second) {
                        score++;
                    }
                    if(first) {
                        score++;
                    }
                    score++;
                    first = false;
                    second = false;
                    third = false;
                }
                if (playerIndex == 9) {
                    playerIndex = 1;
                } else {
                    playerIndex++;
                }
            }
            inning++;
        }

        ans = Math.max(score, ans);
    }
}
