package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class noj16968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String r = br.readLine();
        int ans = 1;
        char cur = r.charAt(0);
        int m = (cur=='d' ? 10 : 26);
        ans *= m;

        for(int i=1; i<r.length(); i++) {
            if(cur == r.charAt(i)) {
                if (m==26 || m==10) {
                    m -= 1;
                }
                ans *= m;
            } else {
                if(cur == 'd') {
                    m = 26;
                    ans *= m;
                } else {
                    m = 10;
                    ans *= m;
                }
            }
            cur = r.charAt(i);
        }
        System.out.println(ans);

    }
}
