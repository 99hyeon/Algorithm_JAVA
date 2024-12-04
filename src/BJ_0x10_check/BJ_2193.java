package BJ_0x10_check;

import java.util.Scanner;

public class BJ_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] array = new long[N + 1];

        array[0] = 0;
        array[1] = 1;

        for(int i = 2; i <= N; i++){
            array[i] = array[i - 1] + array[i - 2];
        }

        System.out.println(array[N]);
    }
}
