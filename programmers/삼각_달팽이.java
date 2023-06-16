package programmers;
import java.util.*;

public class 삼각_달팽이 {
    class Solution {
        public int[] solution(int n) {
            int length = 0;
            if (n%2 == 0) {
                length = (1+n)*(n/2);
            } else {
                length = n*((n+1)/2);
            }
            System.out.println(length);
            int[] answer = new int[length];

            int[][] num = new int[n][n];
            int count = 1;
            int c = 0;
            int x = 0;
            int y = 0;
            while(count <= length) {
                if (c == 0) {
                    while(x<n && num[x][y]==0) {
                        num[x][y] = count;
                        count++;
                        x++;
                    }
                    x--;
                    y++;
                    c++;
                } else if (c == 1) {
                    while(y<n && num[x][y]==0) {
                        num[x][y] = count;
                        count++;
                        y++;
                    }
                    x--;
                    y-=2;
                    c++;
                } else if (c == 2) {
                    System.out.println(x+", "+y);
                    while(x>=0 && y>=0 && num[x][y]==0) {
                        num[x][y] = count;
                        count++;
                        x--;
                        y--;
                    }
                    x+=2;
                    y++;
                    c = 0;
                    System.out.println(x+", "+y);
                    //System.out.println(count);
                }
            }

            int idx = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if (num[i][j] != 0) {
                        answer[idx] = num[i][j];
                        idx++;
                    }
                }
            }

            return answer;
        }
    }
}
