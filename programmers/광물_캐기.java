package programmers;
import java.util.*;
public class 광물_캐기 {
    class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            int[][] tired = {{1,1,1}, {5,1,1}, {25,5,1}};
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<int[]> list = new ArrayList<>();
            map.put("diamond", 0);
            map.put("iron", 1);
            map.put("stone", 2);

            for(int i=0; i<minerals.length; i+=5) {
                int diamond = picks[0] == 0 ? -1 : 0;
                int iron = picks[1] == 0 ? -1 : 0;
                int stone = picks[2] == 0 ? -1 : 0;
                for(int j=i; j<i+5; j++) {
                    if (j < minerals.length) {
                        if (diamond != -1) {
                            diamond += tired[0][map.get(minerals[j])];
                        }
                        if (iron != -1) {
                            iron += tired[1][map.get(minerals[j])];
                        }
                        if (stone != -1) {
                            stone += tired[2][map.get(minerals[j])];
                        }
                    }
                }
                if (diamond == -1) {
                    diamond = Integer.MAX_VALUE;
                }
                if (iron == -1) {
                    iron = Integer.MAX_VALUE;
                }
                if (stone == -1) {
                    stone = Integer.MAX_VALUE;
                }
                list.add(new int[]{diamond, iron, stone});
            }

            Collections.sort(list, (a1, a2) -> a2[2]-a1[2]);

            for(int i=0; i<list.size(); i++) {
                int[] temp = list.get(i);
                if (picks[0] != 0) {
                    answer += temp[0];
                    picks[0]--;
                } else if (picks[1] != 0) {
                    answer += temp[1];
                    picks[1]--;
                } else if (picks[2] != 0) {
                    answer += temp[2];
                    picks[2]--;
                }
            }
            return answer;
        }
    }
}
