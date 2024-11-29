package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1932 {

    static ArrayList<Integer>[] arrayList;
    static int max = Integer.MIN_VALUE;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[size];
        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrayList[i] = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                arrayList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        sum();
        System.out.println(arrayList[0].get(0));

    }

    static void sum(){

        for(int i = size - 1; i >= 1; i--){
            for(int j = 0; j < arrayList[i].size() - 1; j++){
                int topNum = arrayList[i - 1].remove(j);
                int leftNum = arrayList[i].get(j);
                int rightNum = arrayList[i].get(j+1);

                int max = Math.max(leftNum, rightNum);
                arrayList[i-1].add(j, topNum + max);
            }
        }

    }

}
