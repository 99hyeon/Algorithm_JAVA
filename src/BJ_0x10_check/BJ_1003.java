package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1003 {

    static ArrayList<Number> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                sb.append(1).append(" ").append(0).append("\n");
            }else if(num == 1){
                sb.append(0).append(" ").append(1).append("\n");
            }else{
                arrayList = new ArrayList<>();
                arrayList.add(new Number(1, 0));
                arrayList.add(new Number(0, 1));

                findZeroOne(num);
                sb.append(arrayList.get(num).zeroCnt).append(" ").append(arrayList.get(num).oneCnt).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void findZeroOne(int num){
        if(arrayList.size() <= num){
            for(int i = arrayList.size() - 1; i < num; i++){
                int zeroCnt = arrayList.get(i).zeroCnt + arrayList.get(i - 1).zeroCnt;
                int oneCnt = arrayList.get(i).oneCnt + arrayList.get(i - 1).oneCnt;
                arrayList.add(new Number(zeroCnt, oneCnt));
            }
        }
    }

    static class Number{
        int zeroCnt;
        int oneCnt;

        public Number(int zeroCnt, int oneCnt) {
            this.zeroCnt = zeroCnt;
            this.oneCnt = oneCnt;
        }
    }
}
