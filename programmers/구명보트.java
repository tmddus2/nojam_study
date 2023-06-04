package programmers;
import java.util.*;

public class 구명보트 {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int index = 0;
            for(int i = people.length-1; i>=index; i--) {
                if (people[index]+people[i] <= limit) {
                    index++;

                }
                answer++;
            }

            return answer;
        }
    }
}
