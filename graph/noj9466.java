package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class noj9466 {
    static int T;
    static int N;
    static int[] students;
    static boolean[] isTeam;
    static boolean[] visited;
    static int ans = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            students = new int[N + 1];
            String[] s = br.readLine().split(" ");
            for (int i=1; i<=N; i++) {
                students[i] = Integer.parseInt(s[i-1]);
            }
            isTeam = new boolean[N+1];
            visited = new boolean[N+1];
            ans = 0;
            Arrays.fill(isTeam, false);
            Arrays.fill(visited, false);

            for(int i=1;i<=N;i++) {
                checkLoop(i);
            }

            System.out.println(N-ans);


        }

    }

    public static void checkLoop(int now) {
        if(visited[now]) {
            return;
        }

        visited[now] = true;
        int next = students[now];

        if (!visited[next]) {
            checkLoop(next);
        } else {
            if (!isTeam[next]) { // next가 Loop에 포함되는 학생인지 확인
                // 루프가 끊어지면 몇 명이 한 팀인지 세기
                ans += 1; // now도 세주기
                for (int j=next; j != now; j = students[j]) { // next부터 now 직전까지
                    ans += 1;
                }
            }
        }

        isTeam[now] = true;

    }
}
