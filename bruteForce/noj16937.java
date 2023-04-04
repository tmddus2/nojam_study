package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj16937 {
    public static int H, W, N;
    public static int[][] stickers;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        stickers = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if (stickers[i][0]+stickers[j][0] <= H && Math.max(stickers[i][1], stickers[j][1])  <= W) {
                    ans = Math.max(ans, stickers[i][0]*stickers[i][1]+stickers[j][0]*stickers[j][1]);
                    continue;
                } else if (Math.max(stickers[i][0], stickers[j][0]) <= H && stickers[i][1]+stickers[j][1]  <= W) {
                    ans = Math.max(ans, stickers[i][0]*stickers[i][1]+stickers[j][0]*stickers[j][1]);
                    continue;
                } else if (stickers[i][1]+stickers[j][0] <= H && Math.max(stickers[i][0], stickers[j][1]) <= W) {
                    ans = Math.max(ans, stickers[i][0]*stickers[i][1]+stickers[j][0]*stickers[j][1]);
                    continue;
                } else if (Math.max(stickers[i][1], stickers[j][0]) <= H && stickers[i][0]+stickers[j][1] <= W) {
                    ans = Math.max(ans, stickers[i][0]*stickers[i][1]+stickers[j][0]*stickers[j][1]);
                    continue;
                } else if (stickers[i][0]+stickers[j][1] <= H && Math.max(stickers[i][1], stickers[j][0]) <= W) {
                    ans = Math.max(ans, stickers[i][0]*stickers[i][1]+stickers[j][0]*stickers[j][1]);
                    continue;
                } else if (Math.max(stickers[i][0], stickers[j][1]) <= H && stickers[i][1]+stickers[j][0] <= W) {
                    ans = Math.max(ans, stickers[i][0]*stickers[i][1]+stickers[j][0]*stickers[j][1]);
                    continue;
                } else if (stickers[i][1]+stickers[j][1] <= H && Math.max(stickers[i][0], stickers[j][0]) <= W) {
                    ans = Math.max(ans, stickers[i][0]*stickers[i][1]+stickers[j][0]*stickers[j][1]);
                    continue;
                } else if (Math.max(stickers[i][1], stickers[j][1]) <= H && stickers[i][0]+stickers[j][0] <= W) {
                    ans = Math.max(ans, stickers[i][0]*stickers[i][1]+stickers[j][0]*stickers[j][1]);
                    continue;
                }
            }
        }
        System.out.println(ans);
    }
}
