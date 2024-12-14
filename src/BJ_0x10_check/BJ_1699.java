package BJ_0x10_check;

import java.util.Scanner;

public class BJ_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[100001];
        dp[1] = 1;

        for(int i = 2; i <= N; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j < i; j++){
                if(j*j == i){
                    min = 1;
                    break;
                }

                min = Math.min(min, dp[i - j] + dp[j]);
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}

/**
 * 다시
 */
