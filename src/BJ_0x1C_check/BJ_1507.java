package BJ_0x1C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][N + 1];
        int[][] origin = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                cost[i][j] = tmp;
                origin[i][j] = tmp;
            }
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(i == k || k == j || i == j){
                        continue;
                    }

                    if(cost[i][j] == cost[i][k] + cost[k][j]){
                        origin[i][j] = Integer.MAX_VALUE;
                    }else if(cost[i][j] > cost[i][k] + cost[k][j]){
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++){
            for(int j = i; j <= N; j++){
                if(origin[i][j] != Integer.MAX_VALUE){
                    sum += origin[i][j];
                }
            }
        }

        System.out.println(sum);
    }
}

/**
 * 다시
 */