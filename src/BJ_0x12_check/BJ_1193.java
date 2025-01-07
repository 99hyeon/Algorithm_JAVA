package BJ_0x12_check;

import java.io.IOException;
import java.util.Scanner;

public class BJ_1193 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if(num == 1){
            System.out.println("1/1");
            System.exit(0);
        }

        int sum = 1;
        int currentNum = 2;
        while(true){
            sum += currentNum;

            if(num <= sum){
                if(currentNum % 2 == 0){
                    int under = sum - num + 1;
                    int up = currentNum + 1 - under;

                    System.out.println(up +"/"+ under);
                    System.exit(0);
                }else{
                    int up = sum - num + 1;
                    int under = currentNum + 1 - up;

                    System.out.println(up +"/"+ under);
                    System.exit(0);
                }
            }else{
                currentNum++;
            }
        }
    }
}
