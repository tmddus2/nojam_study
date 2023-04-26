package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj16987 {
    public static int N;
    public static int[] S;
    public static int[] W;
    public static boolean[] isBroken;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        W = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }
        isBroken = new boolean[N];
        brokeEgg(0, S, isBroken);

        System.out.println(ans);
    }


    public static void brokeEgg(int egg, int[] s, boolean[] isBroken) {
        if (egg == N) {
            int brokenEgg = 0;
            for(boolean b : isBroken) {
                if (b) {
                    brokenEgg++;
                }
            }
            ans = Math.max(ans, brokenEgg);
            return;
        }


        if (!isBroken[egg]) {
            boolean nothing = true;
            for(int i=0; i<N; i++) {
                if (isBroken[i]==false && i!=egg) {
                    nothing = false;
                    s[i] -= W[egg];
                    s[egg] -= W[i];
                    if (s[i] <= 0) {
                        isBroken[i] = true;
                    }
                    if (s[egg] <= 0) {
                        isBroken[egg] = true;
                    }
                    brokeEgg(egg+1, s, isBroken);
                    s[i] += W[egg];
                    s[egg] += W[i];
                    if (s[i] > 0) {
                        isBroken[i] = false;
                    }
                    if (s[egg] > 0) {
                        isBroken[egg] = false;
                    }
                }
            }
            if (nothing) {
                brokeEgg(egg+1, s, isBroken);
            }
        } else {
            brokeEgg(egg+1, s, isBroken);
        }

    }

}


