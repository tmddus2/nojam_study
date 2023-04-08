package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj15683 {
    public static int N, M;
    public static int[][] map;
    public static Queue<int[]> queue;
    public static Queue<int[][]> queueForMap;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = N*M;
        map = new int[N][M];
        queue = new LinkedList<>();
        queueForMap = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int t = Integer.parseInt(st.nextToken());
                map[i][j] = t;
                if (t!=0 && t!=6) {
                    queue.add(new int[]{i, j, t});
                }
            }
        }
        queueForMap.add(map);
        if (queue.size()==0) {
            ans = Math.min(ans, calArea(map));
        } else {
            bfs();
        }
        System.out.println(ans);
    }

    public static int calArea(int[][] m) {
        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(m[i][j] == 0) {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int cctv = poll[2];
            int size = queueForMap.size();
            for(int s=0; s<size; s++) {
                int[][] curMap = queueForMap.poll();
                if (cctv == 1) {
                    int[][] result1 = returnNewMap(curMap, x, y, 0);
                    int[][] result2 = returnNewMap(curMap, x, y, 1);
                    int[][] result3 = returnNewMap(curMap, x, y, 2);
                    int[][] result4 = returnNewMap(curMap, x, y, 3);
                    if (queue.isEmpty()) {
                        ans = Math.min(ans, calArea(result1));
                        ans = Math.min(ans, calArea(result2));
                        ans = Math.min(ans, calArea(result3));
                        ans = Math.min(ans, calArea(result4));
                    } else {
                        queueForMap.add(result1);
                        queueForMap.add(result2);
                        queueForMap.add(result3);
                        queueForMap.add(result4);
                    }

                } else if (cctv == 2) {
                    int[][] result1 = returnNewMap(returnNewMap(curMap, x, y, 0), x, y, 2);
                    int[][] result2 = returnNewMap(returnNewMap(curMap, x, y, 1), x, y, 3);
                    if (queue.isEmpty()) {
                        ans = Math.min(ans, calArea(result1));
                        ans = Math.min(ans, calArea(result2));
                    } else {
                        queueForMap.add(result1);
                        queueForMap.add(result2);
                    }

                } else if (cctv == 3) {
                    int[][] result1 = returnNewMap(returnNewMap(curMap, x, y, 0), x, y, 1);
                    int[][] result2 = returnNewMap(returnNewMap(curMap, x, y, 0), x, y, 3);
                    int[][] result3 = returnNewMap(returnNewMap(curMap, x, y, 2), x, y, 1);
                    int[][] result4 = returnNewMap(returnNewMap(curMap, x, y, 2), x, y, 3);
                    if (queue.isEmpty()) {
                        ans = Math.min(ans, calArea(result1));
                        ans = Math.min(ans, calArea(result2));
                        ans = Math.min(ans, calArea(result3));
                        ans = Math.min(ans, calArea(result4));
                    } else {
                        queueForMap.add(result1);
                        queueForMap.add(result2);
                        queueForMap.add(result3);
                        queueForMap.add(result4);
                    }

                } else if (cctv == 4) {
                    int[][] result1 = returnNewMap(returnNewMap(returnNewMap(curMap, x, y, 0), x, y, 1), x, y, 3);
                    int[][] result2 = returnNewMap(returnNewMap(returnNewMap(curMap, x, y, 0), x, y, 1), x, y, 2);
                    int[][] result3 = returnNewMap(returnNewMap(returnNewMap(curMap, x, y, 1), x, y, 2), x, y, 3);
                    int[][] result4 = returnNewMap(returnNewMap(returnNewMap(curMap, x, y, 0), x, y, 2), x, y, 3);
                    if (queue.isEmpty()) {
                        ans = Math.min(ans, calArea(result1));
                        ans = Math.min(ans, calArea(result2));
                        ans = Math.min(ans, calArea(result3));
                        ans = Math.min(ans, calArea(result4));
                    } else {
                        queueForMap.add(result1);
                        queueForMap.add(result2);
                        queueForMap.add(result3);
                        queueForMap.add(result4);
                    }

                } else if (cctv == 5) {
                    int[][] result = returnNewMap(returnNewMap(returnNewMap(returnNewMap(curMap, x, y, 0), x, y, 1), x, y, 2), x, y, 3);
                    if (queue.isEmpty()) {
                        ans = Math.min(ans, calArea(result));
                    } else {
                        queueForMap.add(result);
                    }
                }
            }
        }
    }

    public static int[][] returnNewMap(int[][] m, int x, int y, int direction) {
        int[][] result = new int[N][M];
        int DX = dx[direction];
        int DY = dy[direction];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                result[i][j] = m[i][j];
            }
        }
        while(true) {
            int newX = x+DX;
            int newY = y+DY;
            if (!(newX>=0 && newX<N && newY>=0 && newY<M)) {
                break;
            } else if (m[newX][newY] == 6) {
                break;
            } else if (m[newX][newY] == 0) {
                result[newX][newY] = 7; // 7은 감시구역을 의미
            }
            x = newX;
            y = newY;

        }
        return result;
    }
}
