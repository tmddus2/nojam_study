package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class noj8111 {
    public static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //T = Integer.parseInt(br.readLine());

        ArrayList<Integer> aCase = getCase(4);
        for(int a : aCase) {
            System.out.print(a+" ");
        }
        System.out.println();

        ArrayList<Integer> bCase = getCase(5);
        for(int b : bCase) {
            System.out.print(b+" ");
        }
        System.out.println();

    }

    public static int getDigit(int num) {
        int digit = 0;
        while(num != 0) {
            num /= 10;
            digit++;
        }
        return digit;
    }

    public static ArrayList<Integer> getCase(int digit) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //arrayList.add(0);
        //arrayList.add(1);
        arrayList.add(digit*10);
        digit--;
        while (digit != 0) {
            for(int i=0; i<arrayList.size() ; i++) {
                arrayList.add(arrayList.get(i)+digit*10);
            }
            digit--;
        }
        return arrayList;
    }

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        int digit = getDigit(num);

    }
}
