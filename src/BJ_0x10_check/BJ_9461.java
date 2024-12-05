package BJ_0x10_check;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testNum = sc.nextInt();
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(0L);
        arrayList.add(1L);
        arrayList.add(1L);
        arrayList.add(1L);
        arrayList.add(2L);

        for(int i = 0; i < testNum; i++){
            int N = sc.nextInt();

            if(N < 5){
                sb.append(arrayList.get(N)).append("\n");
            }else{
                if(N <= arrayList.size() - 1){
                    sb.append(arrayList.get(N)).append("\n");
                }else{
                    int tmpSize = N - arrayList.size() + 1;
                    for(int j = 0; j < tmpSize; j++){
                        arrayList.add(arrayList.get(arrayList.size() - 1) + arrayList.get(arrayList.size() - 5));
                    }
                    sb.append(arrayList.get(N)).append("\n");
                }

            }
        }

        System.out.println(sb);
    }
}
