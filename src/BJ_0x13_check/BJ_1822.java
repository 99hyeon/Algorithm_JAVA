package BJ_0x13_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1822 {

    static int B;
    static int[] bNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int[] aNums = new int[A];
        bNums = new int[B];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++){
            aNums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++){
            bNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bNums);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < A; i++){
            if(!check(aNums[i])){
                list.add(aNums[i]);
            }
        }

        if(list.isEmpty()){
            System.out.println(0);
        }else{
            Collections.sort(list);

            System.out.println(list.size());
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
    }

    static boolean check(int number){
        int left = 0;
        int right = B - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(number == bNums[mid]){
                return true;
            }else if(number < bNums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }
}
