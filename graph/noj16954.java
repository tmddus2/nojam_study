package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj16954 {
    static char[][] board = new char[8][8];
    static int[] dx = {0,0,0,1,-1,1,1,-1,-1};
    static int[] dy = {0,1,-1,0,0,1,-1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0 ; i<8 ; i++) {
            String t = br.readLine();
            for(int j=0 ; j<8 ; j++) {
                board[i][j] = t.charAt(j);
            }
        }

        System.out.println(bfs() ? 1:0);

    }

    public static void wall_move() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = '.';
                    if (i != 7) {
                        board[i + 1][j] = '#';
                    }
                }
            }
        }
    }

    public static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{7, 0});
        boolean[][] visited;

        while (!q.isEmpty()) {
            int size = q.size();
            visited = new boolean[8][8];

            for(int i=0 ; i<size ; i++) {
                int[] t = q.poll();
                int x = t[0];
                int y = t[1];

                if (board[x][y] == '#') {
                    continue;
                }
                if (x == 0 && y == 7) {
                    return true;
                }

                for(int j=0 ; j<9 ; j++) {
                    int newX = x+dx[j];
                    int newY = y+dy[j];

                    if (0<=newX && newX<8 && 0<=newY && newY<8) {
                        if (visited[newX][newY] == false && board[newX][newY] == '.') {
                            q.add(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        }
                    }

                }
            }

            wall_move();
        }


        return false;

    }


}
