package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class noj1913 {
    public static int N;
    public static int[][] map;
    public static int num;
    public static int[] dx={0,1,0,-1};
    public static int[] dy={1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int start = N/2;
        int count = 1;
        map[start][start] = count;
        int startX = start-1;
        int startY = start;
        int dir = 0;
        for (int i=0; i<start; i++) {
            int num = (i+1)*2;
            int c = num;
            int currentX = startX;
            int currentY = startY;
            for (int j=0; j<(i+1)*8; j++) {
                count++;
                map[currentX][currentY] = count;
                c--;
                if (c == 0) {
                    dir = (dir+1)%4;
                    c = num;
                }
                currentX += dx[dir];
                currentY += dy[dir];
            }
            startX -= 1;
            startY -= 1;
        }


        int x=0;
        int y=0;
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == num) {
                    x = i;
                    y = j;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(x+1).append(" ").append(y+1);
        System.out.println(sb);
    }
}
