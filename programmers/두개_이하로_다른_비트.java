package programmers;

public class 두개_이하로_다른_비트 {
    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = {};
            answer = new long[numbers.length];
            for(int i=0; i<numbers.length; i++) {
                answer[i] = func(numbers[i]);
            }
            return answer;
        }

        public long func(long x) {
            long result = 0;

            if (x%2 == 0) {
                return x+1;
            }

            String binary = Long.toBinaryString(x);
            if (binary.length() == 1) {
                return 2;
            }
            if (binary.charAt(binary.length()-1)=='1' && binary.charAt(binary.length()-2)=='0') {
                return x+1;
            }

            boolean exit = false;
            for(int i=binary.length()-2; i>=0; i--) {
                if (binary.charAt(i) == '0') {
                    binary = binary.substring(0,i)+"10"+binary.substring(i+2, binary.length());
                    exit = true;
                    break;
                }
            }

            if (exit) {
                long cal = 1;
                for(int i=binary.length()-1; i>=0; i--) {
                    if (binary.charAt(i) == '1') {
                        result += cal;
                    }
                    cal *= 2;
                }
                return result;
            }

            long cal = 1;
            for(int i=0; i<binary.length()+1; i++) {
                if (i != binary.length()-1) {
                    result += cal;
                }
                cal *= 2;
            }

            return result;
        }
    }
}
