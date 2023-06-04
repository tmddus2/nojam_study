package programmers;
import java.util.*;

public class 전화번호_목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Arrays.sort(phone_book);
            for(int i=1; i<phone_book.length; i++) {
                if (phone_book[i].startsWith(phone_book[i-1])) {
                    return false;
                }
            }

            return answer;
        }
    }
}
