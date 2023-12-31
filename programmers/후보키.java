package programmers;
import java.util.*;
public class 후보키 {
    class Solution {
        public int answer = 0;
        public Set<Integer> ans = new HashSet<>();
        public int solution(String[][] relation) {
            boolean[] arr = new boolean[relation[0].length];
            dfs(0, 0, relation[0].length, relation);
            return answer;
        }

        public void dfs(int n, int idx, int limit, String[][] relation) {
            if (idx == limit) {
                if (isKey(n, relation) & n!=0) {
                    ans.add(n);
                    answer++;
                }
                return;
            }

            dfs(n, idx+1, limit, relation);
            dfs(n|(1<<(limit-idx-1)), idx+1, limit, relation);


        }

        public boolean isKey(int n, String[][] relation) {
            Set<String> set = new HashSet<>();
            for(int i=0; i<relation.length; i++) {
                String value = "";
                for(int j=0; j<relation[0].length; j++) {
                    if ((n&(1<<(relation[0].length-j-1))) != 0) {
                        value += relation[i][j];
                        value += "\\";
                    }
                }

                if (set.contains(value)) {
                    return false;
                }
                set.add(value);
            }

            Iterator iter = ans.iterator();
            while(iter.hasNext()){
                int temp = (int)iter.next();
                if ((n&temp) == temp) {
                    return false;
                }
            }
            return true;
        }
    }
}
