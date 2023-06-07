package programmers;
import java.util.*;

public class 스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<skill.length(); i++) {
                map.put(String.valueOf(skill.charAt(i)), i+1);
            }
            for(int i=0; i<skill_trees.length; i++) {
                int priority = 1;
                boolean check = true;
                for(int j=0; j<skill_trees[i].length(); j++) {
                    String s = String.valueOf(skill_trees[i].charAt(j));
                    if (map.containsKey(s)) {
                        if (priority == map.get(s)) {
                            priority++;
                        } else {
                            check = false;
                            break;
                        }
                    }
                }

                if (check) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
