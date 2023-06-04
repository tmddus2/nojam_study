package programmers;
import java.util.*;

public class 뉴스_클러스터링 {
    class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;
            answer = getSimilarity(str1, str2);
            return answer;
        }

        public int getSimilarity(String str1, String str2) {
            ArrayList<String> set1 = new ArrayList<>();
            for(int i=0; i<str1.length()-1; i++) {
                String subString = str1.substring(i,i+2).toLowerCase();
                if (subString.charAt(0)>='a' && subString.charAt(0)<='z' && subString.charAt(1)>='a' && subString.charAt(1)<='z') {
                    set1.add(subString);
                }

            }

            ArrayList<String> set2 = new ArrayList<>();
            for(int i=0; i<str2.length()-1; i++) {
                String subString = str2.substring(i,i+2).toLowerCase();
                if (subString.charAt(0)>='a' && subString.charAt(0)<='z' && subString.charAt(1)>='a' && subString.charAt(1)<='z') {
                    set2.add(subString);
                }

            }

            int intersection = 0;
            for(int i=0; i<set1.size(); i++) {
                for(int j=0; j<set2.size(); j++) {
                    if (set1.get(i).equals(set2.get(j))) {
                        intersection++;
                        set1.remove(i);
                        set2.remove(j);
                        i--;
                        j--;
                        break;
                    }
                }
            }

            int union = intersection+set1.size()+set2.size();
            if (union == 0) {
                return 65536;
            }

            return (intersection*65536)/union;
        }
    }
}
