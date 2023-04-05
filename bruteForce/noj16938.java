package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class noj16938 {
    public static int N;
    public static int L;
    public static int R;
    public static int X;
    public static int[] pro;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        pro = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int p=0; p<N; p++) {
            pro[p] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0,0, -1, -1);
        System.out.println(ans);


    }

    public static void dfs(int index, int sum, int num, int max, int min) { // sum은 난이도 합한거, num은 문제 수
        if(index == N) {
            if (sum >= L && sum <= R && num >= 2 && max-min >= X) {
                ans += 1;
            }
            return;
        }
        dfs(index+1, sum, num, max, min);
        if (max == -1 && min == -1) {
            max = pro[index];
            min = pro[index];
        } else if (max<pro[index]) {
            max = pro[index];
        } else if (min>pro[index]) {
            min = pro[index];
        }
        dfs(index+1, sum+pro[index], num+1, max, min);



    }

}
