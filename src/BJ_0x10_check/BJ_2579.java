package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] dp = new int[num + 1][3];
        int[] stairs = new int[num + 1];

        for(int i = 1; i <= num; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }


        for(int i = 1; i <= num; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][1], dp[i-1][2]);
                }else{
                    dp[i][j] = dp[i - 1][j - 1] + stairs[i];
                }
            }
        }

        System.out.println(Math.max(dp[num][1], dp[num][2]));
    }
}
