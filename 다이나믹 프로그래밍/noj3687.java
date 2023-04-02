import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class noj3687 {
    public static void main(String[] args) throws IOException {
        long[] minDp = new long[101];
        String[] maxDp = new String[101];

        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2]=1;
        minDp[3]=7;
        minDp[4]=4;
        minDp[5]=2;
        minDp[6]=6;
        minDp[7]=8;
        minDp[8]=10;

        String[] add = {"1", "7", "4", "2", "0", "8"};

        for (int i=9; i<101; i++){
            for (int j=2; j<=7; j++) {
                String line = minDp[i-j] + add[j-2];
                minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
            }
        }

        maxDp[2] = "1";
        for (int i=3; i<101; i++) {
            String line = "";

            if (i%2 == 0){
                for (int k=0; k<i/2; k++) {
                    line += "1";
                }
            } else {
                int val = i/2-1;
                for (int k=0;k<val;k++) {
                    line += "1";
                }
                int leftMatch = i-val*2;
                line = add[leftMatch-2] + line;
            }
            maxDp[i] = line;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N ;i++) {
            int M = Integer.parseInt(br.readLine());
            System.out.println(minDp[M]+" "+maxDp[M]);
        }

    }
}
