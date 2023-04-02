package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj16917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int ans = 0;
        int m = Math.min(X, Y);
        if (A+B > 2*C) {
            if(X>Y) {
                if(A<2*C) {
                    ans = 2*C*m + A*(X-m);
                } else {
                    ans = 2*C*m + 2*C*(X-m);
                }
            } else {
                if(B<2*C) {
                    ans = 2*C*m + B*(Y-m);
                } else {
                    ans = 2*C*m + 2*C*(Y-m);
                }
            }
        } else {
            if(X>Y) {
                if(A<2*C) {
                    ans = (A+B)*m + A*(X-m);
                } else {
                    ans = (A+B)*m + 2*C*(X-m);
                }
            } else {
                if(B<2*C) {
                    ans = (A+B)*m + B*(Y-m);
                } else {
                    ans = (A+B)*m + 2*C*(Y-m);
                }
            }
        }
        System.out.println(ans);
    }
}
