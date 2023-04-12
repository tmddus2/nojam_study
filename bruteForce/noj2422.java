package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class noj2422 {
    public static int N;
    public static int M;
    public static boolean[][] pairs;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pairs = new boolean[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pairs[a][b] = true;
            pairs[b][a] = true;
        }

        dfs(0,new int[3], 0);
        System.out.println(ans);

    }

    public static void dfs(int index,int[] save, int saveIndex) {
        if (saveIndex == 3) {
            ans += 1;
            return;
        }
        if(index == N) {
            return;
        }
        dfs(index+1, save, saveIndex);
        boolean ok = true;
        for(int j = 0; j<saveIndex; j++) {
            if((index+1 <=N) && (pairs[save[j]][index+1] == true || pairs[index+1][save[j]] == true)) {
                ok = false;
                break;
            }
        }
        if (ok) {
            save[saveIndex] = index+1;
            dfs(index+1, save, saveIndex+1);
        }

    }
}
