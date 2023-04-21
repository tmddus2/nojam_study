package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class noj17779 {
    public static int N;
    public static int[][] jhs;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        jhs = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                jhs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pickValue();
        System.out.println(ans);
    }

    public static void pickValue() {
        for (int x=0; x<N; x++) {
            for (int y=0; y<N; y++) {
                for(int d1=1; d1<N; d1++) {
                    for(int d2=1; d2<N; d2++) {
                        if (x+d1<N && y-d1>=0 && x+d2<N && y+d2<N && x+d1+d2<N && y-d1+d2>=0 && y-d1+d2<N) {
                            int[][] dividedSpace = divideSpace(x, y, d1, d2);
                            int result = calPeople(dividedSpace);
                            ans = Math.min(ans, result);
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<int[]> calEdge(int x, int y, int d1, int d2) {
        ArrayList<int[]> edges = new ArrayList<>();
        edges.add(new int[]{x,y});
        for(int i=1; i<=d1; i++) {
            for(int j=1; j<=d2; j++) {
                edges.add(new int[]{x+i, y-i});
                edges.add(new int[]{x+j, y+j});
                edges.add(new int[]{x+d1+j, y-d1+j});
                edges.add(new int[]{x+d2+i, y+d2-i});
            }
        }
        return edges;
    }

    public static int[][] divideSpace(int x, int y, int d1, int d2) {
        int[][] divided = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (i<x+d1 && j<=y) {
                    divided[i][j] = 1;
                } else if (i<=x+d2 && j>=y && j<N) {
                    divided[i][j] = 2;
                } else if (i>=x+d1 && i<N && j<y-d1+d2) {
                    divided[i][j] = 3;
                } else if(i>x+d2 && i<N && j>=y-d1+d2 && j<N) {
                    divided[i][j] = 4;
                }
            }
        }


        ArrayList<int[]> edges = calEdge(x, y, d1, d2);
        for(int[] e : edges) {
            divided[e[0]][e[1]] = 5;
        }

        for(int i=x+1; i<=x+d1+d2-1; i++) {
            boolean on = false;
            for(int j=y-d1; j<=y+d2; j++) {
                if (divided[i][j] == 5) {
                    on = !on;
                } else if(divided[i][j] != 5 && on == true) {
                    divided[i][j] = 5;
                }
            }
        }

        return divided;



    }

    public static int calPeople(int[][] map) {
        int area1 = 0;
        int area2 = 0;
        int area3 = 0;
        int area4 = 0;
        int area5 = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1) {
                    area1 += jhs[i][j];
                } else if (map[i][j] == 2) {
                    area2 += jhs[i][j];
                } else if (map[i][j] == 3) {
                    area3 += jhs[i][j];
                } else if (map[i][j] == 4) {
                    area4 += jhs[i][j];
                } else if (map[i][j] == 5) {
                    area5 += jhs[i][j];
                }
            }
        }

        int max = area1;
        int min = area1;

        for(int i=2; i<=5; i++) {
            if (i==2) {
                if (max < area2) {
                    max = area2;
                }
                if (min > area2) {
                    min = area2;
                }
            } else if (i==3) {
                if (max < area3) {
                    max = area3;
                }
                if (min > area3) {
                    min = area3;
                }
            } else if (i==4) {
                if (max < area4) {
                    max = area4;
                }
                if (min > area4) {
                    min = area4;
                }
            } else if (i==5) {
                if (max < area5) {
                    max = area5;
                }
                if (min > area5) {
                    min = area5;
                }
            }
        }

        return max-min;

    }
}
