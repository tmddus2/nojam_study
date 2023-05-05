package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj16945 {
    public static int[][] square = new int[3][3];
    public static int ans = Integer.MAX_VALUE;
    public static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            square[i][0] = Integer.parseInt(st.nextToken());
            square[i][1] = Integer.parseInt(st.nextToken());
            square[i][2] = Integer.parseInt(st.nextToken());
        }

        makeArray(0, new int[9]);
        System.out.println(ans);
    }

    public static boolean isMagicSquare(int[] arr) {
        boolean[] check1to9 = new boolean[10];
        for(int i=0; i<9; i++) {
            if (check1to9[arr[i]] == true) {
                return false;
            }
            check1to9[arr[i]] = true;
        }

        int sum1 = arr[0]+arr[1]+arr[2];
        int sum2 = arr[3]+arr[4]+arr[5];
        int sum3 = arr[6]+arr[7]+arr[8];
        if (sum1 != sum2 || sum2 != sum3 || sum1 != sum3) {
            return false;
        }

        sum1 = arr[0]+arr[3]+arr[6];
        sum2 = arr[1]+arr[4]+arr[7];
        sum3 = arr[2]+arr[5]+arr[8];
        if (sum1 != sum2 || sum2 != sum3 || sum1 != sum3) {
            return false;
        }

        sum1 = arr[0]+arr[4]+arr[8];
        sum2 = arr[2]+arr[4]+arr[6];
        if (sum1 != sum2) {
            return false;
        }

        return true;
    }

    public static int calculate(int[] changedNum) {
        int result = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                int idx = i*3+j;
                if (square[i][j] != changedNum[idx]) {
                    result += Math.abs(square[i][j]-changedNum[idx]);
                }
            }
        }
        return result;
    }

    public static void makeArray(int idx, int[] arr) {
        if (idx == 9) {
            if (isMagicSquare(arr)) {
                ans = Math.min(ans, calculate(arr));
            }
            return;
        }

        for(int i=1; i<10; i++) {
            if (visited[i] == false) {
                arr[idx] = i;
                visited[i] = true;
                makeArray(idx+1, arr);
                visited[i] = false;
            }
        }

    }
}
