package BJ_0x10_check;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_10844 {
    static Long[][] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        array = new Long[N + 1][10];


        for(int i = 0; i <= 9; i++){
            array[1][i] = 1L;
        }

        long result = 0;
        for(int i = 1; i < 10; i++){
            result += recursive(N, i);
        }

        System.out.println(result % 1000000000);
    }

    static long recursive(int depth, int num){
        if(depth == 1){
            return array[depth][num];
        }

        if(array[depth][num] == null){
            if(num == 0){
                array[depth][num] = recursive(depth - 1, 1);
            }
            else if(num == 9){
                array[depth][num] = recursive(depth - 1, 8);
            }
            else{
                array[depth][num] = recursive(depth - 1, num - 1) + recursive(depth - 1, num + 1);
            }
        }

        return array[depth][num] % 1000000000;
    }
}

/**
 * 다시
 */
