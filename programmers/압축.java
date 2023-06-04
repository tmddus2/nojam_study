package programmers;
import java.util.*;

public class 압축 {
    class Solution {
        Map<String, Integer> dic = new HashMap<>();
        public int[] solution(String msg) {
            int[] answer = {};
            for(int i=1; i<=26; i++) {
                dic.put(String.valueOf((char)(64+i)), i);
            }

            ArrayList<Integer> result = getIndex(msg);
            answer = new int[result.size()];
            for(int i=0; i<result.size(); i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }

        public ArrayList<Integer> getIndex(String msg) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0; i<msg.length(); i++) {
                String word = "";
                boolean goBack = false;
                for(int j=i+1; j<msg.length()+1; j++) {
                    String sString = msg.substring(i,j);
                    if (dic.containsKey(sString)) {
                        word = sString;
                    } else {
                        dic.put(sString, dic.size()+1);
                        arr.add(dic.get(word));
                        msg = msg.substring(word.length());
                        goBack = true;
                        break;
                    }

                }
                if (goBack) {
                    i = -1;
                }

            }

            if (dic.containsKey(msg)) {
                arr.add(dic.get(msg));
            } else {
                arr.add(dic.size()+1);
            }
            return arr;
        }
    }
}
