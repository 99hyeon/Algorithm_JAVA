package BJ_0x12_check;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ_1038 {

    static List<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        list = new ArrayList<>();

        if(num <= 10){
            System.out.println(num);
        }else if(num > 1022){
            System.out.println(-1);
        }else{
            for(int i = 0; i <= 9; i++){
                bp(i, 1);
            }

            Collections.sort(list);
            System.out.println(list.get(num));
        }
    }

    static void bp(long num, int depth){
        if(depth > 10){
            return;
        }

        list.add(num);
        for(int i = 0; i < num % 10; i++){
            bp(num*10 + i, depth + 1);
        }
    }
}

/**
 * 다시
 */
