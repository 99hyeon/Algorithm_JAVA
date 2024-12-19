package BJ_0x10_check;

import java.util.Scanner;

public class BJ_9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N % 2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }
}