package programmers;
import java.util.*;

public class 소수_찾기 {
    class Solution {
        public boolean[] visited;
        public HashSet<Integer> p = new HashSet<>();
        public int solution(String numbers) {
            int answer = 0;
            char[] number = numbers.toCharArray();
            visited = new boolean[number.length];
            dfs("", number);
            answer = p.size();
            return answer;
        }

        public void dfs(String num, char[] number) {
            if (!num.equals("")) {
                if (isPrime(Integer.parseInt(num))) {
                    p.add(Integer.parseInt(num));
                }
            }
            if (num.length() == number.length) {
                return;
            }

            for(int i=0; i<visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(num+String.valueOf(number[i]), number);
                    visited[i] = false;
                }
            }
        }

        public boolean isPrime(int num) {
            if (num == 1 || num == 0) {
                return false;
            }
            for(int i=2; i < (int)Math.sqrt(num)+1; i++) {
                if (num%i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
