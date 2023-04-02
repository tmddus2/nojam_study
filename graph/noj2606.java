package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class noj2606 {
    static boolean[] visited;
    static int ans = 0;
    static boolean[][] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int connectedNum = Integer.parseInt(br.readLine());
        computers = new boolean[computerNum+1][computerNum+1];
        //Arrays.fill(computers, false);

        for (int i=0; i<connectedNum; i++) {
            String[] c = br.readLine().split(" ");
            computers[Integer.parseInt(c[0])][Integer.parseInt(c[1])] = true;
            computers[Integer.parseInt(c[1])][Integer.parseInt(c[0])] = true;
        }

        visited = new boolean[computerNum+1];
        //Arrays.fill(visited, false);
        //visited[1] = true;

        dfs(1);
        System.out.println(ans);


    }

    public static boolean dfs(int c) {
        if (visited[c] == true) {
            return true;
        } else {
            visited[c] = true;
            for (int i=0; i<computers[c].length; i++) {
                if (computers[c][i] == true && visited[i] != true) {
                    ans += 1;
                    dfs(i);
                }
            }
        }
        return true;
    }
}
