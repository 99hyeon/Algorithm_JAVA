package BJ_0x0F_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2910 {
    static ArrayList<Number> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            int tmpNum = Integer.parseInt(st.nextToken());

            int check = checkNum(tmpNum);
            if(check == -1){
                arrayList.add(new Number(tmpNum, 1));
            }else{
                arrayList.get(check).frequency += 1;
            }
        }

        sort();
        for (Number number : arrayList) {
            for(int i = 0; i < number.frequency; i++){
                sb.append(number.num).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static int checkNum(int num){
        if(arrayList.isEmpty()){
            return -1;
        }

        for(int i = 0; i < arrayList.size(); i++){
            Number tmpNumber = arrayList.get(i);
            if(tmpNumber.num == num){
                return i;
            }
        }
        return -1;
    }

    public static void sort(){
        int front = 0;
        int back = 1;

        while(front < arrayList.size() - 1){
            if(arrayList.get(front).frequency < arrayList.get(back).frequency){
                for(int i = 0; i <= front; i++){
                    if(arrayList.get(i).frequency < arrayList.get(back).frequency){
                        arrayList.add(i, arrayList.remove(back));
                        break;
                    }
                }
            }

            front += 1;
            back += 1;
        }
    }

    static class Number{
        int num;
        int frequency;

        public Number(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }
    }
}
