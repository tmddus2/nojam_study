package programmers;
import java.util.*;

public class 오픈채팅방 {
    class Solution {
        public String[] solution(String[] record) {
            String[] answer = {};
            HashMap<String, String> maps = new HashMap<>();
            int size = 0;
            for(int i=0; i<record.length; i++) {
                String[] info = record[i].split(" ");
                if (info[0].equals("Enter") || info[0].equals("Change")) {
                    maps.put(info[1], info[2]);
                }
                if (info[0].equals("Enter") || info[0].equals("Leave")) {
                    size++;
                }
            }
            answer = new String[size];
            size = 0;
            for(int i=0; i<record.length; i++) {
                String[] info = record[i].split(" ");
                if (info[0].equals("Enter")) {
                    answer[size] = maps.get(info[1])+"님이 들어왔습니다.";
                    size++;
                } else if (info[0].equals("Leave")) {
                    answer[size] = maps.get(info[1])+"님이 나갔습니다.";
                    size++;
                }
            }
            return answer;
        }
    }
}
