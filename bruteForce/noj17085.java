package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class noj17085 {
    public static int N;
    public static int M;
    public static char[][] map;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        ArrayList<int[]> possibleCross = possibleCross();
        pickTwoCross(possibleCross);
        System.out.println(ans);

    }

    public static ArrayList<int[]> possibleCross() {
        ArrayList<int[]> cross = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (map[i][j] == '#') {
                    int length = 0;
                    while(true) {
                        if (i-length>=0 && i+length<N && j-length>=0 && j+length<M) {
                            if (map[i-length][j] == '#' && map[i+length][j] == '#' && map[i][j-length] == '#' && map[i][j+length] == '#') {
                                cross.add(new int[]{i,j,length});
                                length += 1;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return cross;
    }

    public static boolean checkOverlap(int[] a, int[] b) {
        boolean result = false;
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<=a[2]; i++) {
            visited[a[0]+i][a[1]] = true;
            visited[a[0]][a[1]+i] = true;
            visited[a[0]-i][a[1]] = true;
            visited[a[0]][a[1]-i] = true;
        }
        for(int i=0; i<=b[2]; i++) {
            if (visited[b[0]+i][b[1]] || visited[b[0]][b[1]+i] || visited[b[0]-i][b[1]] || visited[b[0]][b[1]-i]) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void pickTwoCross(ArrayList<int[]> crosses) {
        for (int i=0; i<crosses.size()-1; i++) {
            for(int j=1; j<crosses.size(); j++) {
                int[] a = crosses.get(i);
                int[] b = crosses.get(j);
                boolean result = checkOverlap(a, b);
                if (result == false) {
                    int aArea = 1+4*a[2];
                    int bArea = 1+4*b[2];
                    ans = Math.max(ans, aArea*bArea);
                }
            }
        }
    }
}
