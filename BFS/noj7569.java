package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj7569 {
    public static int X,Y,Z;
    public static int[][][] box;
    public static int[] dx = {1,-1,0,0,0,0};
    public static int[] dy = {0,0,1,-1,0,0};
    public static int[] dz = {0,0,0,0,1,-1};
    public static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        box = new int[X][Y][Z];
        int notDone = 0;
        for(int i=0; i<Z; i++) {
            for(int j=0; j<X; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<Y; k++) {
                    int t = Integer.parseInt(st.nextToken());
                    if (t == 0) {
                        notDone++;
                    } else if (t == 1) {
                        queue.add(new int[]{j,k,i});
                    }
                    box[j][k][i] = t;
                }
            }
        }

        if (notDone == 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs(notDone));
        }


    }

    public static int bfs(int num) {
        int depth = 0;
        int notDone = num;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int j=0; j<size; j++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                int z = poll[2];

                for(int i=0; i<6; i++) {
                    int newX = x+dx[i];
                    int newY = y+dy[i];
                    int newZ = z+dz[i];

                    if(newX>=0&&newX<X&&newY>=0&&newY<Y&&newZ>=0&&newZ<Z&&box[newX][newY][newZ]==0) {
                        box[newX][newY][newZ] = 1;
                        notDone--;
                        queue.add(new int[]{newX, newY, newZ});
                    }
                }
            }
            if (!queue.isEmpty()) {
                depth++;
            }
        }

        if (notDone != 0) {
            return -1;
        }
        return depth;

    }
}
