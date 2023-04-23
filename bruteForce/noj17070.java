package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj17070 {
    public static int N;
    public static int[][] house;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        movePipe(0, 0,0,0,1);
        System.out.println(ans);
    }

    public static void movePipe(int direction, int x1, int y1, int x2, int y2) {
        if (x2 == N-1 && y2 == N-1) {
            ans += 1;
            return;
        }
        int newX1 = x1;
        int newY1 = y1;
        int newX2 = x2;
        int newY2 = y2;
        if (direction == 0) { // 가로
            newX1 = x1;
            newY1 = y1+1;
            newX2 = x2;
            newY2 = y2+1;
            if (newX1>=0 && newX1<N && newY1>=0 && newY1<N && newX2>=0 && newX2<N && newY2>=0 && newY2<N) {
                if (house[newX2][newY2] != 1) {
                    movePipe(0, newX1, newY1, newX2, newY2);
                }
            }

            newX1 = x1;
            newY1 = y1+1;
            newX2 = x2+1;
            newY2 = y2+1;
            if (newX1>=0 && newX1<N && newY1>=0 && newY1<N && newX2>=0 && newX2<N && newY2>=0 && newY2<N) {
                if (house[newX2][newY2] != 1 && house[newX2-1][newY2] != 1 && house[newX2][newY2-1] != 1) {
                    movePipe(2, newX1, newY1, newX2, newY2);
                }
            }
        } else if (direction == 1) { // 세로
            newX1 = x1+1;
            newY1 = y1;
            newX2 = x2+1;
            newY2 = y2;
            if (newX1>=0 && newX1<N && newY1>=0 && newY1<N && newX2>=0 && newX2<N && newY2>=0 && newY2<N) {
                if (house[newX2][newY2] != 1) {
                    movePipe(1, newX1, newY1, newX2, newY2);
                }
            }

            newX1 = x1+1;
            newY1 = y1;
            newX2 = x2+1;
            newY2 = y2+1;
            if (newX1>=0 && newX1<N && newY1>=0 && newY1<N && newX2>=0 && newX2<N && newY2>=0 && newY2<N) {
                if (house[newX2][newY2] != 1 && house[newX2-1][newY2] != 1 && house[newX2][newY2-1] != 1) {
                    movePipe(2, newX1, newY1, newX2, newY2);
                }
            }
        } else if (direction == 2) { // 대각선
            newX1 = x1+1;
            newY1 = y1+1;
            newX2 = x2;
            newY2 = y2+1;
            if (newX1>=0 && newX1<N && newY1>=0 && newY1<N && newX2>=0 && newX2<N && newY2>=0 && newY2<N) {
                if (house[newX2][newY2] != 1) {
                    movePipe(0, newX1, newY1, newX2, newY2);
                }
            }

            newX1 = x1+1;
            newY1 = y1+1;
            newX2 = x2+1;
            newY2 = y2;
            if (newX1>=0 && newX1<N && newY1>=0 && newY1<N && newX2>=0 && newX2<N && newY2>=0 && newY2<N) {
                if (house[newX2][newY2] != 1) {
                    movePipe(1, newX1, newY1, newX2, newY2);
                }
            }

            newX1 = x1+1;
            newY1 = y1+1;
            newX2 = x2+1;
            newY2 = y2+1;
            if (newX1>=0 && newX1<N && newY1>=0 && newY1<N && newX2>=0 && newX2<N && newY2>=0 && newY2<N) {
                if (house[newX2][newY2] != 1 && house[newX2-1][newY2] != 1 && house[newX2][newY2-1] != 1) {
                    movePipe(2, newX1, newY1, newX2, newY2);
                }
            }
        }

    }
}
