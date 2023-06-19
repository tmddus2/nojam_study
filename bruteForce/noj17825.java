package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class noj17825 {
    public static int[] scores;
    public static boolean[] visited = new boolean[10];
    public static int ans = 0;
    public static int[] startedFrom10 = new int[]{10,13,16,19,25,30,35,40};
    public static int[] startedFrom20 = new int[]{20,22,24,25,30,35,40};
    public static int[] startedFrom30 = new int[]{30,32,34,36,38,40};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        scores = new int[10];
        for(int i=0; i<10; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        //setOrder(new int[10], 0);
        move(new int[]{4,4,3,2,1,2,2,1,1,3});
        System.out.println(ans);

    }

    public static void setOrder(int[] order, int index) {
        if (index == 10) {
            move(order);
            return;
        }
        for(int i=0; i<10; i++) {
            if (visited[i] == false) {
                order[index] = scores[i];
                visited[i] = true;
                setOrder(order, index+1);
                visited[i] = false;
            }
        }
    }

    public static void move(int[] dice) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 4, 0, 0, 0}); // cur position, left horse, dice index, score , color (0==red 1,2,3==blue)

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curPosition = poll[0];
            int leftHorse = poll[1];
            int diceIndex = poll[2];
            int score = poll[3];
            int color = poll[4]; // 0 is red, 1&2&3 is blue

            if (diceIndex == 10) {
                // 10번 다 굴림
                ans = Math.max(ans, score);
                continue;
            }

            if (color == 0 && curPosition > 40) {
                if (leftHorse == 0) {
                    // game end
                    ans = Math.max(ans, score);
                    continue;
                }
                queue.add(new int[]{0, leftHorse-1, diceIndex, score, 0});
                continue;
            } else if (color == 1 && curPosition >= startedFrom10.length) {
                if (leftHorse == 0) {
                    // game end
                    ans = Math.max(ans, score);
                    continue;
                }
                queue.add(new int[]{0, leftHorse-1, diceIndex, score, 0});
                continue;
            } else if (color == 2 && curPosition >= startedFrom20.length) {
                if (leftHorse == 0) {
                    // game end
                    ans = Math.max(ans, score);
                    continue;
                }
                queue.add(new int[]{0, leftHorse-1, diceIndex, score, 0});
                continue;
            } else if (color == 3 && curPosition >= startedFrom30.length) {
                if (leftHorse == 0) {
                    // game end
                    ans = Math.max(ans, score);
                    continue;
                }
                queue.add(new int[]{0, leftHorse-1, diceIndex, score, 0});
                continue;
            }

            if (color == 0 && curPosition == 10) {
                if (dice[diceIndex] == 1) {
                    int nextPosition = startedFrom10[1];
                    queue.add(new int[]{1, leftHorse, diceIndex+1, score+nextPosition, 1});
                } else if (dice[diceIndex] == 2) {
                    int nextPosition = startedFrom10[2];
                    queue.add(new int[]{2, leftHorse, diceIndex+1, score+nextPosition, 1});
                } else if (dice[diceIndex] == 3) {
                    int nextPosition = startedFrom10[3];
                    queue.add(new int[]{3, leftHorse, diceIndex+1, score+nextPosition, 1});
                } else if (dice[diceIndex] == 4) {
                    int nextPosition = startedFrom10[4];
                    queue.add(new int[]{4, leftHorse, diceIndex+1, score+nextPosition, 1});
                } else if (dice[diceIndex] == 5) {
                    int nextPosition = startedFrom10[5];
                    queue.add(new int[]{5, leftHorse, diceIndex+1, score+nextPosition, 1});
                }
            } else if (color == 0 && curPosition == 20) {
                if (dice[diceIndex] == 1) {
                    int nextPosition = startedFrom20[1];
                    queue.add(new int[]{1, leftHorse, diceIndex+1, score+nextPosition, 2});
                } else if (dice[diceIndex] == 2) {
                    int nextPosition = startedFrom20[2];
                    queue.add(new int[]{2, leftHorse, diceIndex+1, score+nextPosition, 2});
                } else if (dice[diceIndex] == 3) {
                    int nextPosition = startedFrom20[3];
                    queue.add(new int[]{3, leftHorse, diceIndex+1, score+nextPosition, 2});
                } else if (dice[diceIndex] == 4) {
                    int nextPosition = startedFrom20[4];
                    queue.add(new int[]{4, leftHorse, diceIndex+1, score+nextPosition, 2});
                } else if (dice[diceIndex] == 5) {
                    int nextPosition = startedFrom20[5];
                    queue.add(new int[]{5, leftHorse, diceIndex+1, score+nextPosition, 2});
                }
            } else if (color == 0 && curPosition == 30) {
                if (dice[diceIndex] == 1) {
                    int nextPosition = startedFrom30[1];
                    queue.add(new int[]{1, leftHorse, diceIndex+1, score+nextPosition, 3});
                } else if (dice[diceIndex] == 2) {
                    int nextPosition = startedFrom30[2];
                    queue.add(new int[]{2, leftHorse, diceIndex+1, score+nextPosition, 3});
                } else if (dice[diceIndex] == 3) {
                    int nextPosition = startedFrom30[3];
                    queue.add(new int[]{3, leftHorse, diceIndex+1, score+nextPosition, 3});
                } else if (dice[diceIndex] == 4) {
                    int nextPosition = startedFrom30[4];
                    queue.add(new int[]{4, leftHorse, diceIndex+1, score+nextPosition, 3});
                } else if (dice[diceIndex] == 5) {
                    int nextPosition = startedFrom30[5];
                    queue.add(new int[]{5, leftHorse, diceIndex+1, score+nextPosition, 3});
                }
            } else {
                if (color == 1) {
                    //int numPosition = startedFrom10[curPosition]; // 10
                    if (curPosition+dice[diceIndex]<startedFrom10.length) {
                        int nextPosition = startedFrom10[curPosition+dice[diceIndex]];
                        queue.add(new int[]{curPosition+dice[diceIndex], leftHorse, diceIndex+1, score+nextPosition, 1});
                    } else {
                        queue.add(new int[]{curPosition+dice[diceIndex], leftHorse, diceIndex+1, score, 1});
                    }
                } else if(color == 2){
                    //curPosition = startedFrom20[curPosition];
                    if (curPosition+dice[diceIndex]<startedFrom20.length) {
                        int nextPosition = startedFrom20[curPosition+dice[diceIndex]];
                        queue.add(new int[]{curPosition+dice[diceIndex], leftHorse, diceIndex+1, score+nextPosition, 2});
                    } else {
                        queue.add(new int[]{curPosition+dice[diceIndex], leftHorse, diceIndex+1, score, 2});
                    }
                } else if(color ==3) {
                    //curPosition = startedFrom30[curPosition];
                    if (curPosition+dice[diceIndex]<startedFrom30.length) {
                        int nextPosition = startedFrom30[curPosition+dice[diceIndex]];
                        queue.add(new int[]{curPosition+dice[diceIndex], leftHorse, diceIndex+1, score+nextPosition, 3});
                    } else {
                        queue.add(new int[]{curPosition+dice[diceIndex], leftHorse, diceIndex+1, score, 3});
                    }
                } else {
                    int nextPosition = curPosition+2*dice[diceIndex];
                    queue.add(new int[]{nextPosition, leftHorse, diceIndex+1, score+nextPosition, 0});
                }
            }
        }

    }
}
