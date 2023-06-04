package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj13460 {
    public static int N, M;
    public static char[][] map;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int holeX, holeY, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        holeX = 0;
        holeY = 0;
        int redX = 0;
        int redY = 0;
        int blueX = 0;
        int blueY = 0;

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
                if (s.charAt(j) == 'B') {
                    blueX = i;
                    blueY = j;
                } else if (s.charAt(j) == 'R') {
                    redX = i;
                    redY = j;
                } else if (s.charAt(j) == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }


        ans = Integer.MAX_VALUE;
        dfs(redX, redY, blueX, blueY, 0);
        System.out.println(ans);
    }

    public static void dfs(int rx, int ry, int bx, int by, int num) {
        if (num == 10) {
            return;
        }
        if (rx == holeX && ry == holeY && bx != holeX && by != holeY) {
            ans = Math.min(ans, num);
            return;
        }

        for(int i=0; i<4; i++) {
            int[] position = getPosition(rx, ry, bx, by, i);
            int newRedX = position[0];
            int newRedY = position[1];
            int newBlueX = position[2];
            int newBlueY = position[3];
            if (newRedX==newBlueX && newRedY==newBlueY) {
                continue;
            } else if (newRedX==rx &&newRedY==ry && newBlueX==bx && newBlueY==by) {
                continue;
            }
            map[newRedX][newRedY] = 'R';
            map[newBlueX][newBlueY] = 'B';
            map[rx][ry] = '.';
            map[bx][by] = '.';
            dfs(newRedX, newRedY, newBlueX, newBlueY, num+1);
            map[newRedX][newRedY] = '.';
            map[newBlueX][newBlueY] = '.';
            map[rx][ry] = 'R';
            map[bx][by] = 'B';
        }
    }

    public static int[] getPosition(int rx, int ry, int bx, int by, int i) {
        char[][] newMap = new char[N][M];
        for(int j=0; j<N; j++) {
            for(int k=0; k<M; k++) {
                newMap[j][k] = map[j][k];
            }
        }
        int newRedX,newRedY,newBlueX,newBlueY;
        newRedX = rx+dx[i];
        newRedY = ry+dy[i];
        newBlueX = bx+dx[i];
        newBlueY = by+dy[i];
        while (true) {
            if (i == 0) {
                if (ry == by) {
                    if (rx<bx) { // blue 먼저 움직이기
                        if (newMap[newBlueX][newBlueY] == '.') {
                            newMap[newBlueX][newBlueY] = 'B';
                            newMap[bx][by] = '.';
                            bx = newBlueX;
                            by = newBlueY;
                            newBlueX = bx+dx[i];
                            newBlueY = by+dy[i];
                        } else {
                            newBlueX = bx;
                            newBlueY = by;
                        }
                        if (newMap[newRedX][newRedY] == '.') {
                            newMap[newRedX][newRedY] = 'R';
                            newMap[rx][ry] = '.';
                            rx = newRedX;
                            ry = newRedY;
                            newRedX = rx+dx[i];
                            newRedY = ry+dy[i];
                        } else {
                            newRedX = rx;
                            newRedY = ry;
                        }
                    } else if (rx>bx) { // red 먼저 움직이기
                        if (newMap[newRedX][newRedY] == '.') {
                            newMap[newRedX][newRedY] = 'R';
                            newMap[rx][ry] = '.';
                            rx = newRedX;
                            ry = newRedY;
                            newRedX = rx+dx[i];
                            newRedY = ry+dy[i];
                        } else {
                            newRedX = rx;
                            newRedY = ry;
                        }
                        if (newMap[newBlueX][newBlueY] == '.') {
                            newMap[newBlueX][newBlueY] = 'B';
                            newMap[bx][by] = '.';
                            bx = newBlueX;
                            by = newBlueY;
                            newBlueX = bx+dx[i];
                            newBlueY = by+dy[i];
                        } else {
                            newBlueX = bx;
                            newBlueY = by;
                        }
                    }
                } else {
                    if (newMap[newBlueX][newBlueY] == '.') {
                        newMap[newBlueX][newBlueY] = 'B';
                        newMap[bx][by] = '.';
                        bx = newBlueX;
                        by = newBlueY;
                        newBlueX = bx+dx[i];
                        newBlueY = by+dy[i];
                    } else {
                        newBlueX = bx;
                        newBlueY = by;
                    }
                    if (newMap[newRedX][newRedY] == '.') {
                        newMap[newRedX][newRedY] = 'R';
                        newMap[rx][ry] = '.';
                        rx = newRedX;
                        ry = newRedY;
                        newRedX = rx+dx[i];
                        newRedY = ry+dy[i];
                    } else {
                        newRedX = rx;
                        newRedY = ry;
                    }
                }
            } else if (i == 1) {
                if (ry==by) {
                    if (rx<bx) { // red 먼저 움직이기
                        if (newMap[newRedX][newRedY] == '.') {
                            newMap[newRedX][newRedY] = 'R';
                            newMap[rx][ry] = '.';
                            rx = newRedX;
                            ry = newRedY;
                            newRedX = rx+dx[i];
                            newRedY = ry+dy[i];
                        } else {
                            newRedX = rx;
                            newRedY = ry;
                        }
                        if (newMap[newBlueX][newBlueY] == '.') {
                            newMap[newBlueX][newBlueY] = 'B';
                            newMap[bx][by] = '.';
                            bx = newBlueX;
                            by = newBlueY;
                            newBlueX = bx+dx[i];
                            newBlueY = by+dy[i];
                        } else {
                            newBlueX = bx;
                            newBlueY = by;
                        }
                    } else if (rx>bx) { // blue 먼저 움직이기
                        if (newMap[newBlueX][newBlueY] == '.') {
                            newMap[newBlueX][newBlueY] = 'B';
                            newMap[bx][by] = '.';
                            bx = newBlueX;
                            by = newBlueY;
                            newBlueX = bx+dx[i];
                            newBlueY = by+dy[i];
                        } else {
                            newBlueX = bx;
                            newBlueY = by;
                        }
                        if (newMap[newRedX][newRedY] == '.') {
                            newMap[newRedX][newRedY] = 'R';
                            newMap[rx][ry] = '.';
                            rx = newRedX;
                            ry = newRedY;
                            newRedX = rx+dx[i];
                            newRedY = ry+dy[i];
                        } else {
                            newRedX = rx;
                            newRedY = ry;
                        }
                    }
                } else {
                    if (newMap[newBlueX][newBlueY] == '.') {
                        newMap[newBlueX][newBlueY] = 'B';
                        newMap[bx][by] = '.';
                        bx = newBlueX;
                        by = newBlueY;
                        newBlueX = bx+dx[i];
                        newBlueY = by+dy[i];
                    } else {
                        newBlueX = bx;
                        newBlueY = by;
                    }
                    if (newMap[newRedX][newRedY] == '.') {
                        newMap[newRedX][newRedY] = 'R';
                        newMap[rx][ry] = '.';
                        rx = newRedX;
                        ry = newRedY;
                        newRedX = rx+dx[i];
                        newRedY = ry+dy[i];
                    } else {
                        newRedX = rx;
                        newRedY = ry;
                    }
                }
            } else if (i == 2) {
                if (rx == bx) {
                    if (ry < by) { // blue 먼저 움직이기
                        if (newMap[newBlueX][newBlueY] == '.') {
                            newMap[newBlueX][newBlueY] = 'B';
                            newMap[bx][by] = '.';
                            bx = newBlueX;
                            by = newBlueY;
                            newBlueX = bx + dx[i];
                            newBlueY = by + dy[i];
                        } else {
                            newBlueX = bx;
                            newBlueY = by;
                        }
                        if (newMap[newRedX][newRedY] == '.') {
                            newMap[newRedX][newRedY] = 'R';
                            newMap[rx][ry] = '.';
                            rx = newRedX;
                            ry = newRedY;
                            newRedX = rx + dx[i];
                            newRedY = ry + dy[i];
                        } else {
                            newRedX = rx;
                            newRedY = ry;
                        }
                    } else if (ry > by) { // red 먼저 움직이기
                        if (newMap[newRedX][newRedY] == '.') {
                            newMap[newRedX][newRedY] = 'R';
                            newMap[rx][ry] = '.';
                            rx = newRedX;
                            ry = newRedY;
                            newRedX = rx + dx[i];
                            newRedY = ry + dy[i];
                        } else {
                            newRedX = rx;
                            newRedY = ry;
                        }
                        if (newMap[newBlueX][newBlueY] == '.') {
                            newMap[newBlueX][newBlueY] = 'B';
                            newMap[bx][by] = '.';
                            bx = newBlueX;
                            by = newBlueY;
                            newBlueX = bx + dx[i];
                            newBlueY = by + dy[i];
                        } else {
                            newBlueX = bx;
                            newBlueY = by;
                        }
                    }
                } else {
                    if (newMap[newBlueX][newBlueY] == '.') {
                        newMap[newBlueX][newBlueY] = 'B';
                        newMap[bx][by] = '.';
                        bx = newBlueX;
                        by = newBlueY;
                        newBlueX = bx+dx[i];
                        newBlueY = by+dy[i];
                    } else {
                        newBlueX = bx;
                        newBlueY = by;
                    }
                    if (newMap[newRedX][newRedY] == '.') {
                        newMap[newRedX][newRedY] = 'R';
                        newMap[rx][ry] = '.';
                        rx = newRedX;
                        ry = newRedY;
                        newRedX = rx+dx[i];
                        newRedY = ry+dy[i];
                    } else {
                        newRedX = rx;
                        newRedY = ry;
                    }
                }
            } else if (i == 3) {
                if (rx==bx) {
                    if (ry<by) { // red 먼저 움직이기
                        if (newMap[newRedX][newRedY] == '.') {
                            newMap[newRedX][newRedY] = 'R';
                            newMap[rx][ry] = '.';
                            rx = newRedX;
                            ry = newRedY;
                            newRedX = rx+dx[i];
                            newRedY = ry+dy[i];
                        } else {
                            newRedX = rx;
                            newRedY = ry;
                        }
                        if (newMap[newBlueX][newBlueY] == '.') {
                            newMap[newBlueX][newBlueY] = 'B';
                            newMap[bx][by] = '.';
                            bx = newBlueX;
                            by = newBlueY;
                            newBlueX = bx+dx[i];
                            newBlueY = by+dy[i];
                        } else {
                            newBlueX = bx;
                            newBlueY = by;
                        }
                    } else if (ry>by) { // blue 먼저 움직이기
                        if (newMap[newBlueX][newBlueY] == '.') {
                            newMap[newBlueX][newBlueY] = 'B';
                            newMap[bx][by] = '.';
                            bx = newBlueX;
                            by = newBlueY;
                            newBlueX = bx+dx[i];
                            newBlueY = by+dy[i];
                        } else {
                            newBlueX = bx;
                            newBlueY = by;
                        }
                        if (newMap[newRedX][newRedY] == '.') {
                            newMap[newRedX][newRedY] = 'R';
                            newMap[rx][ry] = '.';
                            rx = newRedX;
                            ry = newRedY;
                            newRedX = rx+dx[i];
                            newRedY = ry+dy[i];
                        } else {
                            newRedX = rx;
                            newRedY = ry;
                        }
                    }
                } else {
                    if (newMap[newBlueX][newBlueY] == '.') {
                        newMap[newBlueX][newBlueY] = 'B';
                        newMap[bx][by] = '.';
                        bx = newBlueX;
                        by = newBlueY;
                        newBlueX = bx+dx[i];
                        newBlueY = by+dy[i];
                    } else {
                        newBlueX = bx;
                        newBlueY = by;
                    }
                    if (newMap[newRedX][newRedY] == '.') {
                        newMap[newRedX][newRedY] = 'R';
                        newMap[rx][ry] = '.';
                        rx = newRedX;
                        ry = newRedY;
                        newRedX = rx+dx[i];
                        newRedY = ry+dy[i];
                    } else {
                        newRedX = rx;
                        newRedY = ry;
                    }
                }
            }

            /*
            System.out.print("nowRedX = " + newRedX);
            System.out.print(", nowRedY = " + newRedY);
            System.out.print(", nowBlueX = " + newBlueX);
            System.out.print(", nowBlueY = " + newBlueY);
            System.out.print(", beforeRedX = " + rx);
            System.out.print(", beforeRedY = " + ry);
            System.out.print(", beforeBlueX = " + bx);
            System.out.println(", beforeBlueY = " + by);

            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    System.out.print(map[j][k]);
                }
                System.out.println();
            }
             */
            //System.out.print("nowRedX = " + newRedX);
            //System.out.print(", nowRedY = " + newRedY);
            //System.out.print(", nowBlueX = " + newBlueX);
            //System.out.println(", nowBlueY = " + newBlueY);
            if (newRedX==rx && newRedY==ry && newBlueX==bx && newBlueY==by) {
                return new int[]{newRedX, newRedY, newBlueX, newBlueY};
            }

        }
    }
}
