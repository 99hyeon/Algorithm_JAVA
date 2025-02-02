package BJ_0x1D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] cost = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j && i == X){
                    cost[i][j] = 0;
                    continue;
                }
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cost[u][v] = w;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(cost[i][k] == Integer.MAX_VALUE || cost[k][j] == Integer.MAX_VALUE)
                        continue;

                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, cost[i][X] + cost[X][i]);
        }

        System.out.println(max);
    }
}

/**
 * 다익스트라인데 플로이드로 풀긴함..ㅎ
 */