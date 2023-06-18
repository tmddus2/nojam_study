package programmers;

public class 두_큐_합_같게_만들기 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = -2;
            long sum1 = 0;
            long sum2 = 0;
            for(int q1 : queue1) {
                sum1 += q1;
            }
            for(int q2 : queue2) {
                sum2 += q2;
            }

            int index1 = 0;
            int index2 = queue1.length;
            int num1 = queue1.length;
            int num2 = queue2.length;
            answer = 0;
            while(answer <= 600000) {
                if (sum1 > sum2) {
                    if (index1>=queue1.length) {
                        sum1 -= queue2[index1-queue1.length];
                        sum2 += queue2[index1-queue1.length];
                    } else {
                        sum1 -= queue1[index1];
                        sum2 += queue1[index1];
                    }
                    answer++;
                    num1--;
                    num2++;
                    if (index1 < queue1.length+queue2.length-1) {
                        index1++;
                    } else if (index1 == queue1.length+queue2.length-1) {
                        index1 = 0;
                    }
                } else if (sum1 < sum2) {
                    if (index2>=queue1.length) {
                        sum1 += queue2[index2-queue1.length];
                        sum2 -= queue2[index2-queue1.length];
                    } else {
                        sum1 += queue1[index2];
                        sum2 -= queue1[index2];
                    }
                    answer++;
                    num1++;
                    num2--;
                    if (index2 < queue1.length+queue2.length-1) {
                        index2++;
                    } else if (index2 == queue1.length+queue2.length-1) {
                        index2 = 0;
                    }
                } else if (sum1 == sum2) {
                    return answer;
                }

                if (index1==0 && index2==queue1.length && num1==queue1.length && num2==queue2.length) {
                    return -1;
                }
                if (num1==0 || num2==0) {
                    return -1;
                }
            }
            return -1;
        }
    }
}
