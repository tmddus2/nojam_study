package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class noj16922 {
    public static int N;
    public static int[] l = { 1, 5, 10, 50 };
    public static boolean[] result;
    public static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new boolean[50*N+1];
        cal(0,0, 0);
        System.out.println(ans);

    }
    public static void cal(int num, int sum, int index) {
        if (num == N) {
            if (result[sum] == false) {
                ans += 1;
                result[sum] = true;
            }
            return;
        }
        for(int i=index; i<4; i++) { // 이거 하나 때문에 시간초과 남. IVV나 VIV나 VVI 는 모든 다른 경우이지만 합은 같기 때문에 굳이 이 세 경우를 모두 돌 필요가 없다. 자리순서가 없다고 치고 한 경우만 돌게 한다.
            cal(num+1, sum+l[i], i);
        }
    }
}
