package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noj15684 {
    public static int N,M,H;
    public static boolean[][] connected;
    public static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        connected = new boolean[H+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a][b] = true;
        }



        boolean success = true;
        for(int k=1; k<N+1; k++) {
            if (!move(k)){
                success = false;
                break;
            }
        }
        if (success) {
            ans = 0;
        }

        if (ans == -1) {
            pickLadderOne();
        }
        if (ans == -1) {
            pickLadderTwo(0, new int[2][2]);
        }
        if (ans == -1) {
            pickLadderThree(0, new int[3][2]);
        }
        System.out.println(ans);



    }

    public static boolean move(int start) {
        int x = 1;
        int y = start;

        for(;x<H+1; x++) {
            if (connected[x][y] == true) {
                y+=1;
            } else if (y-1>=1 && connected[x][y-1] == true) {
                y-=1;
            }

        }
        return y == start? true: false;

    }

    public static void pickLadderOne() {
        for(int i=1; i<H+1; i++) {
            for(int j=1; j<N; j++) {
                if (connected[i][j] == false) {
                    if (j-1>=1 && connected[i][j-1] == true) {
                        continue;
                    }
                    if (j+1<=N && connected[i][j+1] == true) {
                        continue;
                    }
                    connected[i][j] = true;
                    ans = check(1);
                    if (ans == 1) {
                        return;
                    }
                    connected[i][j] = false;
                }
            }
        }
    }

    public static void pickLadderTwo(int idx, int[][] ladder) {
        if (ans != -1) {
            return;
        }
        if (idx == 2) {
            connected[ladder[0][0]][ladder[0][1]] = true;
            connected[ladder[1][0]][ladder[1][1]] = true;
            ans = check(2);
            connected[ladder[0][0]][ladder[0][1]] = false;
            connected[ladder[1][0]][ladder[1][1]] = false;
            return;
        }

        if (idx == 0) {
            for(int i=1; i<H+1; i++) {
                for(int j=1; j<N; j++) {
                    if (connected[i][j] == false) {
                        if (j-1>=1 && connected[i][j-1] == true) {
                            continue;
                        }
                        if (j+1<=N && connected[i][j+1] == true) {
                            continue;
                        }
                        int[][] newLadder = new int[2][2];
                        newLadder[0][0] = i;
                        newLadder[0][1] = j;
                        connected[i][j] = true;
                        pickLadderTwo(idx+1, newLadder);
                        connected[i][j] = false;
                    }
                }
            }
        } if (idx == 1) {
            for(int i=ladder[0][0]; i<H+1; i++) {
                for(int j=1; j<N; j++) {
                    if (i==ladder[0][0] && j<=ladder[0][1]) {
                        continue;
                    }
                    if (connected[i][j] == false) {
                        if (j-1>=1 && connected[i][j-1] == true) {
                            continue;
                        }
                        if (j+1<=N && connected[i][j+1] == true) {
                            continue;
                        }
                        int[][] newLadder = new int[2][2];
                        newLadder[0][0] = ladder[0][0];
                        newLadder[0][1] = ladder[0][1];
                        newLadder[1][0] = i;
                        newLadder[1][1] = j;
                        connected[i][j] = true;
                        pickLadderTwo(idx+1, newLadder);
                        connected[i][j] = false;
                    }
                }
            }
        }


    }

    public static void pickLadderThree(int idx, int[][] ladder) {
        if (ans != -1) {
            return;
        }
        if (idx == 3) {
            connected[ladder[0][0]][ladder[0][1]] = true;
            connected[ladder[1][0]][ladder[1][1]] = true;
            connected[ladder[2][0]][ladder[2][1]] = true;
            ans = check(3);
            connected[ladder[0][0]][ladder[0][1]] = false;
            connected[ladder[1][0]][ladder[1][1]] = false;
            connected[ladder[2][0]][ladder[2][1]] = false;
            return;
        }

        if (idx == 0) {
            for(int i=1; i<H+1; i++) {
                for(int j=1; j<N; j++) {
                    if (connected[i][j] == false) {
                        if (j-1>=1 && connected[i][j-1] == true) {
                            continue;
                        }
                        if (j+1<=N && connected[i][j+1] == true) {
                            continue;
                        }
                        int[][] newLadder = new int[3][2];
                        newLadder[0][0] = i;
                        newLadder[0][1] = j;
                        connected[i][j] = true;
                        pickLadderThree(idx+1, newLadder);
                        connected[i][j] = false;
                    }
                }
            }
        } if (idx == 1) {
            for(int i=ladder[0][0]; i<H+1; i++) {
                for(int j=1; j<N; j++) {
                    if (i==ladder[0][0] && j<=ladder[0][1]) {
                        continue;
                    }
                    if (connected[i][j] == false) {
                        if (j-1>=1 && connected[i][j-1] == true) {
                            continue;
                        }
                        if (j+1<=N && connected[i][j+1] == true) {
                            continue;
                        }
                        int[][] newLadder = new int[3][2];
                        newLadder[0][0] = ladder[0][0];
                        newLadder[0][1] = ladder[0][1];
                        newLadder[1][0] = i;
                        newLadder[1][1] = j;
                        connected[i][j] = true;
                        pickLadderThree(idx+1, newLadder);
                        connected[i][j] = false;
                    }
                }
            }
        }
        if (idx == 2) {
            for(int i=ladder[1][0]; i<H+1; i++) {
                for(int j=1; j<N; j++) {
                    if (i==ladder[1][0] && j<=ladder[1][1]) {
                        continue;
                    }
                    if (connected[i][j] == false) {
                        if (j-1>=1 && connected[i][j-1] == true) {
                            continue;
                        }
                        if (j+1<=N && connected[i][j+1] == true) {
                            continue;
                        }
                        int[][] newLadder = new int[3][2];
                        newLadder[0][0] = ladder[0][0];
                        newLadder[0][1] = ladder[0][1];
                        newLadder[1][0] = ladder[1][0];
                        newLadder[1][1] = ladder[1][1];
                        newLadder[2][0] = i;
                        newLadder[2][1] = j;
                        connected[i][j] = true;
                        pickLadderThree(idx+1, newLadder);
                        connected[i][j] = false;
                    }
                }
            }
        }
    }

    public static int check(int ladder) {
        boolean checked = true;
        for(int i=1; i<N+1; i++) {
            if(!move(i)) {
                checked = false;
                break;
            }
        }

        return checked? ladder:-1;
    }
}

