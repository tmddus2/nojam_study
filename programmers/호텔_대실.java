package programmers;
import java.util.*;

public class 호텔_대실 {
    class Solution {
        public int solution(String[][] book_time) {
            int answer = 0;
            ArrayList<String> arr = new ArrayList<>();
            Arrays.sort(book_time, (String[] str1, String[] str2) -> (compareTo(str1, str2)));

            for(int i=0; i<book_time.length; i++) {
                String startTime = book_time[i][0];
                String endTime = book_time[i][1];

                int idx = -1;
                int timeGap = Integer.MAX_VALUE;
                for(int j=0; j<arr.size(); j++) {
                    int temp = getTimeMap(arr.get(j), startTime);
                    if (temp >= 10 && temp < timeGap) {
                        idx = j;
                        timeGap = temp;
                    }
                }

                if (idx == -1) {
                    arr.add(endTime);
                } else {
                    arr.set(idx, endTime);
                }

            }
            return arr.size();
        }

        public int getTimeMap(String time1, String time2) {
            String[] parsed1 = time1.split(":");
            int H1 = Integer.parseInt(parsed1[0]);
            int M1 = Integer.parseInt(parsed1[1]);
            String[] parsed2 = time2.split(":");
            int H2 = Integer.parseInt(parsed2[0]);
            int M2 = Integer.parseInt(parsed2[1]);

            return M2-M1+(H2-H1)*60;
        }

        public int compareTo(String[] str1, String[] str2) {
            String[] parsed1 = str1[0].split(":");
            int H1 = Integer.parseInt(parsed1[0]);
            int M1 = Integer.parseInt(parsed1[1]);
            String[] parsed2 = str2[0].split(":");
            int H2 = Integer.parseInt(parsed2[0]);
            int M2 = Integer.parseInt(parsed2[1]);

            if (H1 > H2) {
                return 1;
            }
            if (H1 == H2) {
                if (M1 > M2) {
                    return 1;
                } else {
                    return -1;
                }
            }
            if (H1 < H2) {
                return -1;
            }

            return -1;
        }
    }
}
