package programmers;
import java.util.*;

public class 우박수열_정적분 {
    class Solution {
        public double[] solution(int k, int[][] ranges) {
            double[] answer = new double[ranges.length];
            ArrayList<Integer> positions = new ArrayList<>();
            positions.add(k);
            while (k > 1) {
                if (k%2==0) {
                    k = k/2;
                    positions.add(k);
                    continue;
                }
                k = k*3+1;
                positions.add(k);
            }

            HashMap<Integer, Double> map = new HashMap<>();
            for(int i=0; i< positions.size()-1; i++) {
                double space = (positions.get(i)+positions.get(i+1))/2.0;
                map.put(i, space);
            }

            for(int i=0; i<ranges.length; i++) {
                int a = ranges[i][0];
                int b = positions.size()-1+ranges[i][1];

                double size = 0;
                if (a <= b) {
                    for(int j=a; j<b; j++) {
                        size += map.get(j);
                    }
                } else {
                    size = -1;
                }
                answer[i] = size;
            }
            return answer;
        }
    }
}
