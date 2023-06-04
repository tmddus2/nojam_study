package programmers;
import java.util.*;

public class 의상 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            Map<String, ArrayList<String>> hashMap = new HashMap<>();
            for(int i=0; i<clothes.length; i++) {
                String key = clothes[i][1];
                String value = clothes[i][0];
                if (hashMap.containsKey(key)) {
                    hashMap.get(key).add(value);
                    continue;
                }
                hashMap.put(key, new ArrayList<String>());
                hashMap.get(key).add(value);
            }
            answer = 1;
            for (Map.Entry<String, ArrayList<String>> entrySet : hashMap.entrySet()) {
                int size = entrySet.getValue().size()+1;
                answer *= size;
            }
            return answer-1;
        }
    }
}
