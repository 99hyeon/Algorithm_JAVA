package BJ_0x1C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dist = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    dist[i][j] = 0;
                }else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            dist[x][y] = d;
            dist[y][x] = d;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                if(dist[i][j] <= m){
                    sum += item[j];
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
