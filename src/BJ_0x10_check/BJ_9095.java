package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int t = Integer.parseInt(br.readLine());
        int maxCalculateNum = 3;
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());

            if(n > maxCalculateNum){
                for(int j = maxCalculateNum + 1; j <= n; j++){
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
