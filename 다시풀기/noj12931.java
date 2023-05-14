package 다시풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj12931 {
    public static int N;
    public static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        B = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            sum += B[i];
        }

        int ans = 0;
        while(sum!=0) {
            for (int i=0; i<N; i++) {
                if (B[i]%2 == 1) {
                    B[i] = B[i]-1;
                    sum--;
                    ans++;
                }
            }
            if (sum == 0) {
                continue;
            }
            for (int i=0; i<N; i++) {
                B[i] = B[i]/2;
            }
            sum /= 2;
            ans++;
        }
        System.out.println(ans);
    }


}
