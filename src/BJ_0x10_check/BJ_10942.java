package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] dp = new int[num + 1][num + 1];
        int[] tmp = new int[num + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= num; i++){
            tmp[i] = Integer.parseInt(st.nextToken());
        }

        for(int j = 1; j <= num; j++){
            for(int i = 1; i <= j; i++){
                if(i == j){
                    dp[i][j] = 1;
                }else {
                    if(j - i == 1){
                        dp[i][j] = (tmp[i] == tmp[j]) ? 1 : 0;
                    }else{
                        dp[i][j] = (tmp[i] == tmp[j] && dp[i+1][j-1] == 1) ? 1 : 0;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e]).append("\n");
        }

        br.close();
        System.out.println(sb);
    }
}
