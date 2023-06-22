package programmers;

public class 행렬_테두리_회전하기 {
    class Solution {
        public int[] dx = {0,1,0,-1};
        public int[] dy = {1,0,-1,0};
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            int[][] input = new int[rows][columns];
            int num = 1;
            for(int i=0; i<rows; i++) {
                for(int j=0; j<columns; j++) {
                    input[i][j] = num;
                    num++;
                }
            }

            for(int i=0; i<queries.length; i++) {
                int x1 = queries[i][0];
                int y1 = queries[i][1];
                int x2 = queries[i][2];
                int y2 = queries[i][3];
                ArrayInfo info = rotateArray(input, x1-1, y1-1, x2-1, y2-1);
                input = info.arr;
                answer[i] = info.num;
            }
            return answer;
        }

        public ArrayInfo rotateArray(int[][] arr, int x1, int y1, int x2, int y2) {
            int[][] result = new int[arr.length][arr[0].length];
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[0].length; j++) {
                    result[i][j] = arr[i][j];
                }
            }
            int num = Integer.MAX_VALUE;
            int X = x1;
            int Y = y1;
            int[] size = new int[]{Math.abs(y1-y2),Math.abs(x1-x2),Math.abs(y1-y2),Math.abs(x1-x2)};
            for(int i=0; i<4; i++) { 
                for(int j=0; j<size[i]; j++) {
                    int newX = X+dx[i];
                    int newY = Y+dy[i];
                    result[newX][newY] = arr[X][Y];
                    num = Math.min(num, arr[X][Y]);
                    X = newX;
                    Y = newY;
                }
            }

            return new ArrayInfo(result, num);
        }
    }

    class ArrayInfo {
        int[][] arr;
        int num;

        public ArrayInfo(int[][] arr, int num) {
            this.arr = arr;
            this.num = num;
        }
    }

}
