package BJ_0x0F_check;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_5648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = sc.nextInt();
        ArrayList<Long> arrayList = new ArrayList<>();

        for(int i = 0; i < num; i++){
            StringBuffer stringBuffer = new StringBuffer(sc.next());
            String reverse = stringBuffer.reverse().toString();

            long reverseNum = Long.parseLong(reverse);
            arrayList.add(reverseNum);
        }

        Collections.sort(arrayList);
        for (Long aLong : arrayList) {
            sb.append(aLong).append("\n");
        }

        System.out.println(sb);
    }
}
