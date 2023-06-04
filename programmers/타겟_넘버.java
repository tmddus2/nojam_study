package programmers;

public class 타겟_넘버 {
    class Solution {
        public int ans = 0;
        public int N, T;
        public int[] NUMS;
        public int solution(int[] numbers, int target) {
            int answer = 0;
            N = numbers.length;
            T = target;
            NUMS = numbers;
            dfs(0,0);
            answer = ans;
            return answer;
        }

        public void dfs(int idx, int num) {
            if (idx == N) {
                if (num == T) {
                    ans++;
                }
                return;
            }
            dfs(idx+1, num+NUMS[idx]);
            dfs(idx+1, num-NUMS[idx]);
        }
    }
}
