package programmers;
import java.util.*;

public class 파일명_정렬 {
    class Solution {
        public String[] solution(String[] files) {
            String[] answer = {};
            String[][] parsed = new String[files.length][3];
            for(int i=0; i<files.length; i++) {
                parsed[i] = parse(files[i]);
            }
            Arrays.sort(parsed, (String[] arr1, String[] arr2) -> compareTo(arr1, arr2));
            answer = new String[files.length];
            for(int i=0; i<files.length; i++) {
                answer[i] = parsed[i][0]+parsed[i][1]+parsed[i][2];
            }

            return answer;
        }


        public int compareTo(String[] file1, String[] file2) {
            if (file1[0].toUpperCase().compareTo(file2[0].toUpperCase()) != 0) {
                return file1[0].toUpperCase().compareTo(file2[0].toUpperCase());
            }

            if (Integer.parseInt(file1[1]) != Integer.parseInt(file2[1])) {
                if (Integer.parseInt(file1[1]) < Integer.parseInt(file2[1])) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        }

        public String[] parse(String file) {
            String[] result = new String[]{"","",""};
            int idx = 0;
            int res = 0;
            String s = "";
            for(int i=0; i<file.length(); i++) {
                if (res == 0) {
                    char c = file.charAt(i);
                    if (c>57 || c<48) {
                        s += String.valueOf(c);
                    }
                    else {
                        result[res] = s;
                        res++;
                        s = String.valueOf(c);
                    }
                } else if (res == 1) {
                    char c = file.charAt(i);
                    if (c>=48 && c<=57) {
                        s += String.valueOf(c);
                        if (s.length() > 5) {
                            result[res] = s;
                            res++;
                            s = String.valueOf(c);
                        }
                    } else {
                        result[res] = s;
                        res++;
                        s = String.valueOf(c);
                    }
                } else if (res == 2) {
                    char c = file.charAt(i);
                    if (i != file.length()-1) {
                        s += String.valueOf(c);
                    } else {
                        result[res] = s+String.valueOf(c);
                    }
                }
            }
            if (res == 1) {
                result[res] = s;
            }
            return result;
        }
    }
}
