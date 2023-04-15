package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class noj17135 {
    public static int N, M, D;
    public static int[][] map;
    public static ArrayList<int[]> enemy;
    public static int enemyNum = 0;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        enemy = new ArrayList<>();
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int t = Integer.parseInt(st.nextToken());
                map[i][j] = t;
                if (t==1) {
                    enemy.add(new int[]{i, j});
                    enemyNum++;
                }
            }
        }

        dfs(0,0,new int[3]);
        System.out.println(ans);
    }

    public static int calDistance(int x1, int y1, int x2, int y2) { // 두 위치의 거리 계산
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    public static int[] pickEnemy(int x, int y, ArrayList<int[]> enemy) { // 궁수의 위치 x, 궁수의 위치 y
        int[] e = new int[2];
        e[0] = -1;
        e[1] = -1;
        int distance = Integer.MAX_VALUE;

        for(int[] pos : enemy) {
            int dis = calDistance(x, y, pos[0], pos[1]);
            if (dis < distance && dis <= D) {
                distance = dis;
                e[0] = pos[0];
                e[1] = pos[1];
            } else if (dis == distance && dis <= D) {
                if (e[1] > pos[1]) {
                    e[0] = pos[0];
                    e[1] = pos[1];
                }
            }
        }

        return e;

    }

    public static ArrayList<int[]> moveMap(ArrayList<int[]> enemy) { // 공격이 끝나고 적을 이동시킴, 공격이 끝난 후 새로운 enemy가 들어와야 함.
        int[][] resultMap = new int[N][M];
        ArrayList<int[]> newEnemy = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                resultMap[i][j] = 0;
            }
        }

        for(int[] e : enemy) {
            if (e[0]+1 < N) {
                resultMap[e[0]+1][e[1]] = 1;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (resultMap[i][j] == 1) {
                    newEnemy.add(new int[]{i,j});
                }
            }
        }

        return newEnemy;

    }

    public static ArrayList<int[]> updateEnemy(ArrayList<int[]> enemy, int x, int y) { // x,y는 공격하는 적의 위치
        ArrayList<int[]> newEnemy = new ArrayList<>();

        for(int[] e : enemy) {
            if (e[0] == x && e[1] == y) {
                continue;
            }
            newEnemy.add(new int[] {e[0], e[1]});
        }

        return newEnemy;
    }

    public static void playGame(int[] archers, ArrayList<int[]> enemy) {
        ArrayList<int[]> copyEnemies = new ArrayList<>();
        for(int[] e : enemy) {
            copyEnemies.add(new int[]{e[0], e[1]});
        }

        int numEnemy = copyEnemies.size();
        int finalKilledNum = 0;
        while (!(numEnemy == 0)) {
            ArrayList<int[]> pickedEnemies = new ArrayList<>();
            for(int a : archers) {
                int[] killedEnemies = pickEnemy(N, a, copyEnemies);
                boolean contains = false;
                for(int[] p : pickedEnemies) {
                    if (p[0] == killedEnemies[0] && p[1] == killedEnemies[1]) {
                        contains = true;
                    }
                }
                if (!contains && killedEnemies[0] != -1 && killedEnemies[1] != -1) {
                    pickedEnemies.add(killedEnemies);
                    finalKilledNum++;
                }
            }
            for(int[] p :pickedEnemies) {
                copyEnemies = updateEnemy(copyEnemies, p[0], p[1]);
            }
            copyEnemies = moveMap(copyEnemies);
            numEnemy = copyEnemies.size();
        }
        ans = Math.max(ans, finalKilledNum);

    }

    public static void dfs(int num, int index, int[] archers) {
        if (index == 3) {
            // 조합이 다 골라졌을 때
            playGame(archers, enemy);
            return;
        }

        if(num == M) {
            return;
        }

        dfs(num+1, index, archers);
        archers[index] = num;
        dfs(num+1, index+1, archers);
    }
}
