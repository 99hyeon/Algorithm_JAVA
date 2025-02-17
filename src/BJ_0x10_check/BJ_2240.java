package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[T + 1][W + 1][3];
        for(int i = 1; i <= T; i++){
            int treeNum = Integer.parseInt(br.readLine());
            int otherNum = treeNum == 1 ? 2 : 1;

            for(int j = 0; j <= W; j++){
                if(j == 0){
                    if(i == 1 && treeNum == 2){
                        continue;
                    }
                    dp[i][j][treeNum] = dp[i - 1][j][treeNum] + 1;
                    dp[i][j][otherNum] = dp[i - 1][j][otherNum];
                }else{
                    dp[i][j][treeNum] = Math.max(dp[i - 1][j][treeNum], dp[i - 1][j - 1][otherNum]) + 1;
                    dp[i][j][otherNum] = dp[i - 1][j][otherNum];
                }
            }
        }

        int max = 0;
        for(int i = 0; i <= W; i++){
            max = Math.max(max, Math.max(dp[T][i][1], dp[T][i][2]));
        }

        System.out.println(max);
    }
}

/**
 * 다시
 */
