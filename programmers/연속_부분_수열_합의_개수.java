package programmers;

public class 연속_부분_수열_합의_개수 {
    class Solution {
        public int solution(int[] elements) {
            int answer = 0;
            boolean[] d = new boolean[1000001];
            for(int i=1; i<elements.length+1; i++) {
                for(int j=0; j<elements.length; j++) {
                    int v = getSum(i,j,elements);
                    if (!d[v]) {
                        answer++;
                        d[v] = true;
                    }
                }
            }
            return answer;
        }

        public int getSum(int start, int length, int[] elements) {
            int result = 0;
            int index = start;
            for(int i=start; i<start+length; i++) {
                if (index == elements.length) {
                    index = 0;
                }
                result += elements[index];
                index++;
            }
            return result;
        }
    }
}
