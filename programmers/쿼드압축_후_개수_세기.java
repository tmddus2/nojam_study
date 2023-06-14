package programmers;
import java.util.*;

public class 쿼드압축_후_개수_세기 {
    class Solution {
        public int[] solution(int[][] arr) {
            int[] answer = {};

            if (arr.length == 1) {
                answer = new int[]{0,0};
                if (arr[0][0] == 0) {
                    answer[0] += 1;
                } else {
                    answer[1] += 1;
                }
                return answer;
            }

            Queue<Arr> queue = new LinkedList<>();
            ArrayList<Arr> divided = divideArr(arr);
            boolean alreadyCompession = true;
            for(int i=0; i<divided.size(); i++) {
                if (alreadyCompession && !divided.get(i).compession) {
                    alreadyCompession = false;
                }
                queue.add(divided.get(i));
            }

            if (alreadyCompession) {
                answer = new int[]{0,0};
                if (arr[0][0] == 0) {
                    answer[0] += 1;
                } else {
                    answer[1] += 1;
                }
                return answer;
            }

            int num = arr.length;
            while(num != 0) {
                int size = queue.size();
                for(int i=0; i<size; i++) {
                    Arr a = queue.poll();
                    if (!a.compession) { // 더 나눠야 할 때
                        ArrayList<Arr> newDivided = divideArr(a.arr);
                        for(int j=0; j<newDivided.size(); j++) {
                            queue.add(newDivided.get(j));
                        }
                    } else {
                        queue.add(a);
                    }
                }
                num /= 2;
            }

            answer = new int[]{0,0};
            Iterator iter = queue.iterator();
            while(iter.hasNext()) {
                Arr a = (Arr) iter.next();

                if (a.compession) {
                    if (a.arr[0][0] == 0) {
                        answer[0] += 1;
                    } else {
                        answer[1] += 1;
                    }
                } else {
                    for(int i=0; i<a.arr.length; i++) {
                        for(int j=0; j<a.arr[0].length; j++) {
                            if (a.arr[i][j] == 0) {
                                answer[0] += 1;
                            } else {
                                answer[1] += 1;
                            }
                        }
                    }
                }
            }
            return answer;
        }

        public ArrayList<Arr> divideArr(int[][] arr) {
            int length = arr.length / 2;
            ArrayList<Arr> result = new ArrayList<>();
            for(int i=0; i<4; i++) {
                int[][] smallArr = new int[length][length];
                boolean compression = true;
                if (i == 0) {
                    for(int j=0; j<length; j++) {
                        for (int k=0; k<length; k++) {
                            if (compression && arr[j][k]!=arr[0][0]) {
                                compression = false;
                            }
                            smallArr[j][k] = arr[j][k];
                        }
                    }
                } else if (i == 1) {
                    for(int j=0; j<length; j++) {
                        for (int k=0; k<length; k++) {
                            if (compression && arr[j+length][k]!=arr[length][0]) {
                                compression = false;
                            }
                            smallArr[j][k] = arr[j+length][k];
                        }
                    }
                } else if (i == 2) {
                    for(int j=0; j<length; j++) {
                        for (int k=0; k<length; k++) {
                            if (compression && arr[j][k+length]!=arr[0][length]) {
                                compression = false;
                            }
                            smallArr[j][k] = arr[j][k+length];
                        }
                    }
                } else if (i == 3) {
                    for(int j=0; j<length; j++) {
                        for (int k=0; k<length; k++) {
                            if (compression && arr[j+length][k+length]!=arr[length][length]) {
                                compression = false;
                            }
                            smallArr[j][k] = arr[j+length][k+length];
                        }
                    }
                }
                result.add(new Arr(smallArr, compression));
            }

            return result;
        }

        class Arr {
            public int[][] arr;
            public boolean compession;

            public Arr(int[][] arr, boolean compession) {
                this.arr = arr;
                this.compession = compession;
            }
        }
    }
}
