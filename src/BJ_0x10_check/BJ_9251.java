package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        for(int i = 1; i <= first.length; i++){
            for(int j = 1; j <= second.length; j++){

                if(first[i - 1] == second[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[first.length][second.length]);
    }
}

/**
 * 다시
 */