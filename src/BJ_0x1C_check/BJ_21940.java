package BJ_0x1C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_21940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j){
                    dist[i][j] = 0;
                }else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            dist[x][y] = d;
        }

        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> friends = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            friends.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int max;
        int[] maxArray = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            max = Integer.MIN_VALUE;
            for (Integer friend : friends) {
                if(dist[friend][i] == Integer.MAX_VALUE || dist[i][friend] == Integer.MAX_VALUE)
                    continue;
                max = Math.max(max, dist[friend][i] + dist[i][friend]);
            }

            maxArray[i] = max;
        }

        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            if(maxArray[i] < min){
                min = maxArray[i];
                list.clear();
                list.add(i);
            }else if(maxArray[i] == min){
                list.add(i);
            }
        }

        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }
}
