package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class noj2210 {
    public static List<String> list = new ArrayList<>();
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static String[][] map = new String[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for(int k=0; k<5; k++) {
            for(int j=0; j<5; j++) {
                dfs(k,j,0, map[k][j]);
            }
        }
        System.out.println(list.size());


    }

    public static void dfs(int x, int y, int cnt, String temp) {
        if (cnt == 5) {
            if(!list.contains(temp)) {
                list.add(temp);
            }
            return;
        }
        for(int i=0; i<4; i++) {
            int newX = x+dx[i];
            int newY = y+dy[i];
            if ((0<=newX&&newX<5) && (0<=newY&&newY<5)) {
                dfs(newX, newY, cnt+1, temp+map[newX][newY]);
            }
        }
    }
}
