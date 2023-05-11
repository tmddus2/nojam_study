package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj16985 {
    public static int[][][] cube = new int[5][5][5];
    public static boolean[] picked = new boolean[5];
    public static int ans = Integer.MAX_VALUE;
    public static boolean[][][] visited = new boolean[5][5][5];
    public static int[] dx = {1,-1,0,0,0,0};
    public static int[] dy = {0,0,1,-1,0,0};
    public static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                cube[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                cube[1][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                cube[2][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                cube[3][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                cube[4][i][j] = Integer.parseInt(st.nextToken());
            }
        }


        makeCube(0, new int[5]);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else{
            System.out.println(ans);
        }
    }

    public static void makeCube(int idx, int[] order) {
        if (idx == 5) {
            rotate(0, arrangeCube(order));
            return;
        }

        for(int i=0; i<5; i++) {
            if (picked[i] ==  false) {
                int[] newOrder = new int[5];
                for(int j=0; j< order.length; j++) {
                    newOrder[j] = order[j];
                }
                newOrder[idx] = i;
                picked[i] = true;
                makeCube(idx+1, newOrder);
                picked[i] = false;
            }
        }
    }

    public static int[][][] arrangeCube(int[] order) {
        int[][][] newCube = new int[5][5][5];
        for(int i=0; i<order.length; i++) {
            newCube[i] = cube[order[i]];
        }
        return newCube;
    }

    public static void rotate(int step, int[][][] cubeCase){
        if (step == 5) {
            if (cubeCase[0][0][0]==0 || cubeCase[4][4][4]==0) {
                return;
            }
            bfs(cubeCase);
            if (ans == 12){
                return;
            }
            return;
        }

        rotate( step+1, cubeCase);

        int[][] copy = new int[5][5];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                copy[j][4-i] = cubeCase[step][i][j];
            }
        }
        cubeCase[step] = copy;
        rotate( step+1, cubeCase);

        copy = new int[5][5];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                copy[j][4-i] = cubeCase[step][i][j];
            }
        }
        cubeCase[step] = copy;
        rotate( step+1, cubeCase);

        copy = new int[5][5];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                copy[j][4-i] = cubeCase[step][i][j];
            }
        }
        cubeCase[step] = copy;
        rotate( step+1, cubeCase);

    }

    public static void bfs(int[][][] cube) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,0});
        visited = new boolean[5][5][5];
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];
            int step = poll[3];

            if (x==4 && y==4 && z==4) {
                ans = Math.min(ans, step);
                break;
            }

            for(int i=0; i<6; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                int newZ = z+dz[i];

                if (newX>=0 && newX<5 && newY>=0 && newY<5 && newZ>=0 && newZ<5 && visited[newX][newY][newZ]==false && cube[newX][newY][newZ]==1) {
                    visited[newX][newY][newZ] = true;
                    queue.add(new int[]{newX, newY, newZ, step+1});
                }
            }
        }


    }
}
