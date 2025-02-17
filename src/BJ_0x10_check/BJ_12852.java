package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] trace = new int[N + 1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= N; i++){
            if(i % 2 == 0){
                dp[i] = dp[i / 2] + 1;
                trace[i] = i/2;
            }
            if(i % 3 == 0){
                if(dp[i] == 0 || dp[i] > dp[i / 3] + 1){
                    dp[i] = dp[i / 3] + 1;
                    trace[i] = i / 3;
                }
            }
            if(dp[i] == 0 || dp[i] > dp[i - 1] + 1){
                dp[i] = dp[i - 1] + 1;
                trace[i] = i - 1;
            }
        }

        sb.append(dp[N]).append("\n");
        int traceIdx = N;
        sb.append(N).append(" ");
        while(traceIdx > 1){
            sb.append(trace[traceIdx]).append(" ");
            traceIdx = trace[traceIdx];
        }

        System.out.println(sb);
    }

}
