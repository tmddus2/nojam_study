package programmers;

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};

            int yX = 1;
            int yY = yellow;
            while (true) {
                if (2*(yX+yY)+4 == brown) {
                    answer = new int[]{yY+2, yX+2};
                    break;
                }
                while(true) {
                    yX++;
                    if (yellow%(yX) == 0) {
                        yY = yellow/yX;
                        break;
                    }
                }
            }

            return answer;
        }

    }
}
