package programmers;
import java.util.*;

public class 메뉴_리뉴얼 {
    class Solution {
        public ArrayList<Course> arr;
        public String[] solution(String[] orders, int[] course) {
            ArrayList<String> result = new ArrayList<>();
            for(int i=0; i<course.length; i++) {
                arr = new ArrayList<>();
                arr.add(new Course("", 0));
                for(int j=0; j<orders.length; j++) {
                    dfs("", orders[j], 0, course[i], orders);
                }
                for(int j=0; j<arr.size(); j++) {
                    if (!arr.get(j).course.equals("")) {
                        char[] temp = arr.get(j).course.toCharArray();
                        Arrays.sort(temp);
                        String c = new String(temp);
                        if (!result.contains(c)) {
                            result.add(c);
                        }
                    }
                }
            }
            String[] answer = new String[result.size()];
            for(int i=0; i<answer.length; i++) {
                answer[i] = result.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }

        public void dfs(String s, String order, int idx, int length, String[] orders) {
            if (s.length() == length) {
                int n = howManyOrder(s, orders);
                if (n > 1) {
                    if (arr.get(0).order < n) {
                        arr = new ArrayList<>();
                        arr.add(new Course(s, n));
                    } else if (arr.get(0).order == n && !arr.get(0).course.equals(s)) {
                        arr.add(new Course(s, n));
                    }
                }
            }
            if (idx == order.length()) {
                return;
            }
            for(int i=idx; i<order.length(); i++) {
                dfs(s+String.valueOf(order.charAt(i)), order, i+1, length, orders);
            }
        }

        public int howManyOrder(String course, String[] orders) {
            int result = 0;
            for(int i=0; i<orders.length; i++) {
                String order = orders[i];
                boolean check = true;
                for(int j=0; j<course.length(); j++) {
                    if (!order.contains(String.valueOf(course.charAt(j)))) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    result++;
                }
            }

            return result;
        }
    }

    class Course {
        String course;
        int order;

        public Course(String course, int order) {
            this.course = course;
            this.order = order;
        }
    }
}
