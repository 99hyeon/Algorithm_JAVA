package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();

        int[] numbers = new int[password.length() + 1];
        for(int i = 1; i <= password.length(); i++){
            numbers[i] = password.charAt(i - 1) - '0';
        }

        long[] dp = new long[password.length() + 1];
        dp[0] = 0;

        if(checkZero(numbers[1])){
            System.out.println(0);
            System.exit(0);
        }

        if(password.length() == 1){
            System.out.println(1);
            System.exit(0);
        }

        dp[1] = 1;
        if(checkZero(numbers[2]) && checkSize(numbers[1],numbers[2])){
            System.out.println(0);
            System.exit(0);
        }
        if(checkZero(numbers[2]) || checkSize(numbers[1],numbers[2])){
            dp[2] = 1;
        }else{
            dp[2] = 2;
        }

        for(int i = 3; i < dp.length; i++){
            boolean zero = checkZero(numbers[i]);
            boolean size = checkSize(numbers[i-1],numbers[i]);

            if(zero && size){
                System.out.println(0);
                System.exit(0);
            }

            if(numbers[i] == numbers[i-1] * 10 + numbers[i]){
                if(zero){
                    System.out.println(0);
                    System.exit(0);
                }else{
                    dp[i] = dp[i-1];
                }
            }else{
                dp[i] = ((zero ? 0 : dp[i - 1]) + (size ? 0 : dp[i - 2])) % 1000000;
            }
        }

        System.out.println(dp[password.length()]);
    }

    static boolean checkZero(int number){
        return number == 0;
    }

    static boolean checkSize(int ten, int one){
        int number = ten*10 + one;

        return number > 26;
    }
}
