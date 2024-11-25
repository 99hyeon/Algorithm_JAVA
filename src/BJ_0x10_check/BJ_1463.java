package BJ_0x10_check;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1463 {

    static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        array = new int[number + 1];

        if(number == 1){
            System.out.println(0);
        }else if(number == 2 || number == 3){
            System.out.println(1);
        }else {
            array[2] = 1;
            array[3] = 1;

            for(int i = 4; i <= number; i++){
                operation(i);
            }
            System.out.println(array[number]);
        }
    }

    static void operation(int num){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(num % 2 == 0){
            arrayList.add(array[num / 2]);
        }
        if(num % 3 == 0){
            arrayList.add(array[num / 3]);
        }
        arrayList.add(array[num - 1]);

        int min = Integer.MAX_VALUE;
        for (Integer integer : arrayList) {
            min = Math.min(min, integer);
        }

        array[num] = min + 1;
    }
}
