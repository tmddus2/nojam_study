package programmers;
import java.util.*;

public class 가장_큰_수 {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            String[] numbersString = new String[numbers.length];
            for(int i=0; i<numbers.length; i++) {
                numbersString[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(numbersString, (str1, str2) -> compareTo(str1, str2));

            if (numbersString[0].equals("0")) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for(String s : numbersString) {
                sb.append(s);
            }
            return sb.toString();
        }

        public int compareTo(String str1, String str2) {
            return (str2+str1).compareTo(str1+str2);
        }
    }
}
