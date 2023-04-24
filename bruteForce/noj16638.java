package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class noj16638 {
    public static int N;
    public static char[] cal;
    public static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cal = br.readLine().toCharArray();

        addBracket(0, new ArrayList<>());
        System.out.println(ans);
    }

    public static void addBracket(int index, ArrayList<String> added) {
        if (index >= cal.length) {
            ArrayList<String> removeBracket = removeBracket(added);
            ArrayList<String> removeMulti = removeMulti(removeBracket);
            ans = Math.max(ans, finalCalculate(removeMulti));
            return;
        }

        if (cal[index] == '+' || cal[index] == '-' || cal[index] == '*') {
            ArrayList<String> newAdded1 = new ArrayList<>();
            for(String a : added) {
                newAdded1.add(a);
            }
            newAdded1.add(String.valueOf(cal[index]));
            addBracket(index+1, newAdded1);
        } else if (index != cal.length-1){
            ArrayList<String> newAdded2 = new ArrayList<>();
            for(String a : added) {
                newAdded2.add(a);
            }
            newAdded2.add(String.valueOf(cal[index]));
            addBracket(index+1, newAdded2);

            ArrayList<String> newAdded3 = new ArrayList<>();
            for(String a : added) {
                newAdded3.add(a);
            }
            newAdded3.add("(");
            newAdded3.add(String.valueOf(cal[index]));
            newAdded3.add(String.valueOf(cal[index+1]));
            newAdded3.add(String.valueOf(cal[index+2]));
            newAdded3.add(")");
            addBracket(index+3, newAdded3);

        } else if (index == cal.length-1) {
            ArrayList<String> newAdded4 = new ArrayList<>();
            for(String a : added) {
                newAdded4.add(a);
            }
            newAdded4.add(String.valueOf(cal[index]));
            addBracket(index+1, newAdded4);
        }

    }

    public static ArrayList<String> removeBracket(ArrayList<String> added) {
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i< added.size(); i++) {
            if (added.get(i) != "(") {
                result.add(added.get(i));
            } else {
                int cal = 0;
                int a = Integer.parseInt(added.get(i+1));
                int b = Integer.parseInt(added.get(i+3));
                String type = added.get(i+2);

                if (type.equals("+")) {
                    cal = a+b;
                } else if (type.equals("-")) {
                    cal = a-b;
                } else if (type.equals("*")) {
                    cal = a*b;
                }
                result.add(Integer.toString(cal));
                i+=4;
            }
        }

        return result;
    }

    public static ArrayList<String> removeMulti(ArrayList<String> added) {
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i< added.size(); i++) {
            if (added.get(i).equals("*")) {
                int a = Integer.parseInt(result.get(result.size()-1));
                int b = Integer.parseInt(added.get(i+1));
                result.remove(result.size()-1);
                result.add(Integer.toString(a*b));
                i+=1;
            } else {
                result.add(added.get(i));
            }
        }
        return result;
    }

    public static int finalCalculate(ArrayList<String> added) {
        int result = Integer.parseInt(added.get(0));
        for(int i=1; i< added.size(); i++) {
            if (added.get(i).equals("+")) {
                result += Integer.parseInt(added.get(i+1));
                i+=1;
            } else if (added.get(i).equals("-")) {
                result -= Integer.parseInt(added.get(i+1));
                i+=1;
            }
        }
        return result;
    }
}
