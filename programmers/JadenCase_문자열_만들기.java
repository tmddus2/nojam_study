package programmers;

public class JadenCase_문자열_만들기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] words = s.split(" ");
            String[] UpperCase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
            String[] LowerCase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            for (int i=0; i<words.length; i++) {
                String word = words[i];
                if (word.length() > 0) {
                    String newWord = "";
                    for(int j=0; j<word.length(); j++) {
                        char c = word.charAt(j);
                        if (j==0 && c>=97 && c<=122) {
                            newWord += UpperCase[c-97];
                        } else if (j!=0 && c>=65 && c<=90) {
                            newWord += LowerCase[c-65];
                        } else {
                            newWord += String.valueOf(c);
                        }
                    }
                    answer += newWord+" ";
                } else {
                    answer += " ";
                }

            }
            if (answer.length() != s.length()) {
                answer = answer.substring(0, answer.length()-1);
            }
            return answer;
        }
    }
}
