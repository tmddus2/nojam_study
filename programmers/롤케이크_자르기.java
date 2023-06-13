package programmers;

public class 롤케이크_자르기 {
    import java.util.*;

    class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            HashSet<Integer> first = new HashSet<>();
            HashMap<Integer, Integer> second = new HashMap<>();
            first.add(topping[0]);
            for(int i=1; i<topping.length; i++) {
                second.put(topping[i], second.getOrDefault(topping[i],0)+1);
            }
            if (first.size() == second.size()) {
                answer++;
            }
            for(int i=1; i<topping.length; i++) {
                first.add(topping[i]);
                int num = second.get(topping[i]);
                second.put(topping[i], num-1);
                num--;
                if (num == 0) {
                    second.remove(topping[i]);
                }
                if (first.size() == second.size()) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
