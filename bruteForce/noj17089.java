package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj17089 {
    public static int N, M;
    public static boolean[][] friend;
    public static int[] friendNum;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friend = new boolean[N+1][N+1];
        friendNum = new int[N+1];
        for(int i=0; i<N+1; i++) {
            friendNum[i] = 0;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = true;
            friend[b][a] = true;
            friendNum[a] += 1;
            friendNum[b] += 1;
        }

        for(int i=1; i<N+1; i++) {
            dfs(i,1,new int[]{i,0,0});
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    public static void dfs(int startFriend, int num, int[] friends) {
        if (num==3) {
            ans = Math.min(ans, friendNum[friends[0]]+friendNum[friends[1]]+friendNum[friends[2]]-6);
            return;
        }
        if (startFriend==N+1){
            return;
        }

        for(int i=startFriend+1; i<N+1; i++) {
            boolean isFriend = true;
            for(int f=0; f<num; f++) {
                if (!friend[i][friends[f]]) {
                    isFriend = false;
                    break;
                }
            }
            if (isFriend) {
                friends[num] = i;
                dfs(i,num+1, friends);
            }
        }

    }
}
