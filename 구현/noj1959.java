package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj1959 {
    public static int M,N;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int ans = 0;

        int x = 0;
        int y = 0;
        int dir = 0;
        int movingSizeX = M-2;
        int movingSizeY = N-1;
        int dxSize = movingSizeX;
        int dySize = movingSizeY;
        for(int i=0; i<M*N; i++) {
            System.out.print("x = " + x);
            System.out.println(", y = " + y);
            if (dxSize == 0) {
                dir = (dir+1)%4;
                movingSizeX--;
                dxSize = movingSizeX;
                ans += 1;
                x = x+dx[dir];
                y = y+dy[dir];
            }
            else if (dySize == 0) {
                dir = (dir+1)%4;
                movingSizeY--;
                dySize = movingSizeY;
                ans += 1;
                x = x+dx[dir];
                y = y+dy[dir];
            } else {
                if (movingSizeX == 0 || movingSizeY == 0) {
                    dir = (dir+1)%4;
                    ans += 1;
                    x = x+dx[dir];
                    y = y+dy[dir];
                    continue;
                }
                if (dir==0 || dir==2) {
                    dySize--;
                } else if (dir==1 || dir==3) {
                    dxSize--;
                }
                x = x+dx[dir];
                y = y+dy[dir];
            }

        }

        System.out.println(ans);
        System.out.print(x+1);
        System.out.print(" ");
        System.out.println(y+1);
    }
}
