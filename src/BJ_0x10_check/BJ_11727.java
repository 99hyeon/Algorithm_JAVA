package BJ_0x10_check;

import java.util.Scanner;

public class BJ_11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i = 2; i < dp.length; i++){
            dp[i] = (dp[i - 1] + 2*dp[i - 2]) % 10007;
        }

        System.out.println(dp[n - 1]);
    }
}

/**
 * 다시 풀기
 */
