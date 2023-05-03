package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj16988 {
    public static int N, M;
    public static int[][] map;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int ans = 0;
    public static boolean[][] visited;
    public static boolean[][] picked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        picked = new boolean[N][M];
        visited = new boolean[N][M];

        pickTwo(0,0,0,new int[2][2]);
        System.out.println(ans);
    }

    public static void pickTwo(int x, int y, int idx, int[][] two) {
        if (idx==2) {
            calKilled(two);
            return;
        }


        for(int i=x;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (picked[i][j] == false) {
                    if (map[i][j]==0) {
                        int[][] newTwo = new int[2][2];
                        for(int k=0; k<2; k++) {
                            for(int l=0; l<2; l++) {
                                newTwo[k][l] = two[k][l];
                            }
                        }
                        newTwo[idx][0] = i;
                        newTwo[idx][1] = j;
                        picked[i][j] = true;
                        pickTwo(i,j,idx+1,newTwo);
                        picked[i][j] = false;
                    }
                }
            }
        }


    }

    public static int checkGroup(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        boolean[][] newVisited = new boolean[N][M];
        newVisited[x][y] = true;
        int num =0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int i=0; i<4; i++) {
                int newX = poll[0]+dx[i];
                int newY = poll[1]+dy[i];
                if (newX>=0 && newX<N && newY>=0 && newY<M) {
                    if (map[newX][newY] == 2 && newVisited[newX][newY] == false) {
                        newVisited[newX][newY] = true;
                        visited[newX][newY] = true;
                        if (num != -1) {
                            num+=1;
                            queue.add(new int[]{newX, newY});
                        }
                    } else if (map[newX][newY] == 0) {
                        num = -1;
                        //break;
                    }
                }
            }
        }
        return num == -1 ? -1 : num+1;
    }

    public static void calKilled(int[][] two) {
        map[two[0][0]][two[0][1]] = 1;
        map[two[1][0]][two[1][1]] = 1;
        int total = 0;
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 2 && visited[i][j] == false) {
                    visited[i][j] = true;
                    int k = checkGroup(i, j);
                    if (k!=-1) {
                        total += k;
                    }
                }
            }
        }

        ans = Math.max(ans, total);
        map[two[0][0]][two[0][1]] = 0;
        map[two[1][0]][two[1][1]] = 0;
    }
}
