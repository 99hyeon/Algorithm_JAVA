package BJ_0x1C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cost = new int[n + 1][n + 1];
        int[][] firstNode = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    cost[i][j] = 0;
                    firstNode[i][j] = i;
                }else{
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cost[u][v] = w;
            cost[v][u] = w;
            firstNode[u][v] = v;
            firstNode[v][u] = u;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(cost[i][k] == Integer.MAX_VALUE || cost[k][j] == Integer.MAX_VALUE)
                        continue;

                    if(cost[i][j] > cost[i][k] + cost[k][j]){
                        cost[i][j] = cost[i][k] + cost[k][j];
                        firstNode[i][j] = firstNode[i][k];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    sb.append("-").append(" ");
                }else{
                    sb.append(firstNode[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
