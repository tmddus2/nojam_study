package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class noj16637 {
    public static int N;
    public static char[] c;
    public static boolean flag = false;
    public static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        c = br.readLine().toCharArray();

        brute(0, "");
        System.out.println(ans);
    }

    public static ArrayList<String> removeBrace(ArrayList<String> calC) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i=0; i<calC.size(); i++) {
            if (calC.get(i).equals("(")) {
                int t = 0;
                if (calC.get(i+2).equals("+")){
                    t = Integer.parseInt(String.valueOf(calC.get(i+1))) + Integer.parseInt(String.valueOf(calC.get(i+3)));
                } else if (calC.get(i+2).equals("-")){
                    t = Integer.parseInt(String.valueOf(calC.get(i+1))) - Integer.parseInt(String.valueOf(calC.get(i+3)));
                } else if (calC.get(i+2).equals("*")){
                    t = Integer.parseInt(String.valueOf(calC.get(i+1))) * Integer.parseInt(String.valueOf(calC.get(i+3)));
                }
                i = i+4;
                strings.add(String.valueOf(t));

            } else {
                strings.add(String.valueOf(calC.get(i)));
            }
        }
        return strings;
    }

    public static int returnFinalResult(ArrayList<String> calC) {
        ArrayList<String> temp1 = removeBrace(calC);
        int result = 0;
        String symbol = "+";
        for(int i=0; i<temp1.size(); i++) {
            if (temp1.get(i).equals("+") || temp1.get(i).equals("-") || temp1.get(i).equals("*")) {
                symbol = temp1.get(i);
            } else {
                if (symbol.equals("+")) {
                    result += Integer.parseInt(temp1.get(i));
                } else if (symbol.equals("-")) {
                    result -= Integer.parseInt(temp1.get(i));
                } else if (symbol.equals("*")) {
                    result *= Integer.parseInt(temp1.get(i));
                }
            }
        }
        return result;
    }
    public static void brute(int index, String input) {
        if (index >= N) {
            ArrayList<String> inp = new ArrayList<>();
            for (int j=0; j<input.length(); j++) {
                inp.add(String.valueOf(input.charAt(j)));
            }
            int result = returnFinalResult(inp);
            if (flag == false) {
                ans = result;
                flag = true;
            } else {
                ans = Math.max(ans, result);
            }
            return;
        }

        String temp1 = input;
        String temp2 = input;
        if(c[index] != '+' && c[index] != '-' && c[index] != '*') {
            if (index == N-1) {
                brute(index+1,input+c[index]);
            } else {
                temp1 += String.valueOf(c[index]);
                brute(index+1, temp1);
                temp2 += "(";
                temp2 += String.valueOf(c[index]);
                temp2 += String.valueOf(c[index+1]);
                temp2 += String.valueOf(c[index+2]);
                temp2 += ")";
                brute(index+3, temp2);
            }
        } else {
            brute(index+1,input+c[index]);
        }


    }
}
