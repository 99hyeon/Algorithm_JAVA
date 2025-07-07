package BJ_0x1C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11780 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] cost = new int[n + 1][n + 1];
        int[][] path = new int[n + 1][n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(cost[a][b] == 0 || (cost[a][b] != 0 && cost[a][b] > c)){
                cost[a][b] = c;
                path[a][b] = a;
            }
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(cost[i][k] == 0 || cost[k][j] == 0 || i == j)  continue;

                    if(cost[i][j] == 0 || (cost[i][j] != 0 && cost[i][j] > cost[i][k] + cost[k][j])) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(cost[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(cost[i][j] == 0) sb.append("0\n");
                else{
                    int end = j;
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(j);
                    while(end != i){
                        end = path[i][end];
                        if(end == 0) break;

                        tmpList.add(end);
                    }

                    sb.append(tmpList.size()).append(" ");
                    for(int k = tmpList.size() - 1; k >= 0; k--){
                        sb.append(tmpList.get(k)).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }

}