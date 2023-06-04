package programmers;
import java.util.*;

public class k진수에서_소수_개수_구하기 {
    class Solution {
        public int solution(int n, int k) {
            int answer = -1;
            ArrayList<Long> result = makeN(n,k);
            answer = isPrime(result);
            return answer;
        }

        public ArrayList<Long> makeN(int n, int k) {
            String result = "";
            ArrayList<Long> primes = new ArrayList<>();
            while(n != 0) {
                result = String.valueOf(n%k)+result;
                n /= k;
            }
            String[] p = result.split("0");
            for(String pp : p) {
                if (pp.equals("1")) {
                    continue;
                }
                if (pp.equals("")) {
                    continue;
                }
                primes.add(Long.parseLong(pp));
            }
            return primes;
        }

        public int isPrime(ArrayList<Long> primes) {
            int result = 0;

            for(int i=0; i<primes.size(); i++) {
                Long p = primes.get(i);
                boolean isP = true;
                long a = (long)Math.sqrt(p) + 1; // 끝까지 다 확인할 필요 없다!
                for(int j=2; j<a; j++) {
                    if (p%j == 0) {
                        isP = false;
                        break;
                    }
                }
                if (isP) {
                    result++;
                }
            }
            return result;
        }
    }
}
