import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Switch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] switchs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            switchs[i] = Integer.parseInt(st.nextToken());
        }

        int caseN = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseN; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(s.nextToken());
            int num = Integer.parseInt(s.nextToken()) - 1;
            if (gender == 1) {
                for (int j = num; j < N; j = j + num + 1) {
                    switchs[j] = (switchs[j] == 1 ? 0 : 1);
                }
            } else if (gender == 2) {
                switchs[num] = (switchs[num] == 1 ? 0 : 1);
                for (int j = num - 1; j >= 0; j--) {
                    if ((2 * num - j < N) && (switchs[j] == switchs[2 * num - j])) {
                        switchs[j] = (switchs[j] == 1 ? 0 : 1);
                        switchs[2 * num - j] = (switchs[2 * num - j] == 1 ? 0 : 1);
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(switchs[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}