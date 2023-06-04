package programmers;
import java.util.*;

public class 캐시 {
    class Solution {
        public Queue<String> cache = new LinkedList<>();
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            for(int i=0; i<cities.length; i++) {
                int c = checkCache(cacheSize, cities[i].toUpperCase());
                answer += c;
                if (cache.size()>=cacheSize && c == 5){
                    cache.add(cities[i].toUpperCase());
                    cache.poll();
                } else if (cache.size()<cacheSize && c == 5) {
                    cache.add(cities[i].toUpperCase());
                } else {
                    int size = cache.size();
                    for (int j=0; j<size; j++) {
                        String city = cache.poll();
                        if (!city.equals(cities[i].toUpperCase())) {
                            cache.add(city.toUpperCase());
                        }
                    }
                    cache.add(cities[i].toUpperCase());
                }
            }
            return answer;
        }

        public int checkCache(int cacheSize, String city) {
            Iterator<String> iter = cache.iterator();
            while(iter.hasNext()){
                String c = iter.next();
                if (c.equals(city.toUpperCase())) {
                    return 1;
                }
            }
            return 5;
        }
    }
}
