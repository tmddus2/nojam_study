package programmers;

public class 모음사전 {
    class Solution {
        int order = 0;
        int ans = 0;
        String[] aeiou = new String[]{"A","E","I","O","U"};
        public int solution(String word) {
            int answer = 0;
            dfs(word,"");
            answer = ans;
            return answer;
        }

        public void dfs(String word, String now) {
            if (now.equals(word)) {
                ans = order;
                return;
            }

            for(int i=0; i<5; i++) {
                if (now.length()<5) {
                    order++;
                    dfs(word, now+aeiou[i]);
                }
            }
        }
    }
}
