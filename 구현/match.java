package 구현;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class match {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] matchs = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };// new int[10];

        long[] minDp = new long[101];
        String[] maxDp = new String[101];
        Arrays.fill(minDp, Long.MAX_VALUE); // max value로 채워주기

        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        minDp[8] = 10; // 10까지 해야하는 이유 => dp로 돌리면 점화식 상 minDp[1]도 접근하게 되는데 minDp[1]은 만들 수가 없기 때문에 에러 발생
        // 8까지 초기화 해주면 dp는 9부터 돌게 되는데 이때는 minDp[2]까지 접근하게 됨

        String[] add = { "1", "7", "4", "2", "0", "8" };

        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String line = minDp[i - j] + add[j - 2]; // 그냥 string으로 붙이면 됨
                minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
            }
        }

        for (int i = 0; i < minDp.length; i++) {
            System.out.print(minDp[i] + " ");
        }

    }
}
