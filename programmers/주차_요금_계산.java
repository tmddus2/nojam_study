package programmers;
import java.util.*;

public class 주차_요금_계산 {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};
            HashMap<String, Integer> cars = new HashMap<>();
            for(int i=0; i<records.length; i++) {
                String[] info = records[i].split(" ");
                if (info[2].equals("IN") && !cars.containsKey(info[1])) {
                    cars.put(info[1], calculateMin(info[0], "23:59"));
                } else if (info[2].equals("IN") && cars.containsKey(info[1])) {
                    Integer prevalue = cars.get(info[1]);
                    cars.put(info[1], prevalue+calculateMin(info[0], "23:59"));
                } else if (info[2].equals("OUT")) {
                    Integer prevalue = cars.get(info[1]);
                    cars.put(info[1], prevalue-calculateMin(info[0], "23:59"));
                }
            }
            Object[] keys = cars.keySet().toArray();
            Arrays.sort(keys);
            answer = new int[keys.length];
            for(int i=0; i<keys.length; i++) {
                int time = cars.get(keys[i]);
                if (fees[0] >= time) {
                    answer[i] = fees[1];
                    continue;
                }
                int unit = 0;
                if ((time-fees[0])%fees[2] == 0) {
                    unit = (time-fees[0])/fees[2];
                } else {
                    unit = (time-fees[0])/fees[2]+1;
                }
                answer[i] = fees[1]+unit*fees[3];
            }
            return answer;
        }

        public int calculateMin(String time1, String time2) {
            String[] first = time1.split(":");
            String[] second = time2.split(":");
            int time1H = Integer.parseInt(first[0]);
            int time1M = Integer.parseInt(first[1]);
            int time2H = Integer.parseInt(second[0]);
            int time2M = Integer.parseInt(second[1]);
            if ((time1H>time2H) || (time1H==time2H && time1M>time2M)) {
                int temp= time2H;
                time2H = time1H;
                time1H = temp;
                temp = time2M;
                time2M = time1M;
                time1M = temp;
            }
            return time2M-time1M+60*(time2H-time1H);
        }
    }
}
