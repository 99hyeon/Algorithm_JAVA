package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cost[i][0] = r + Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] = g + Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] = b + Math.min(cost[i - 1][0], cost[i - 1][1]);
        }

        int min = Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2]));
        System.out.println(min);
    }

}
