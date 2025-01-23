package BJ_0x18_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] array = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            array[light][heavy] = 1;
        }

        for(int k = 0; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(array[i][k] == 1 && array[k][j] == 1){
                        array[i][j] = 1;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int guide = N / 2;
        int count = 0;
        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 0; j <= N; j++){
                if(array[i][j] == 1){
                    sum += 1;
                    if(sum > guide){
                        list.add(i);
                        count++;
                        break;
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            int sum = 0;
            if(list.contains(i)) continue;

            for(int j = 0; j <= N; j++){
                if(array[j][i] == 1){
                    sum += 1;
                    if(sum > guide){
                        list.add(i);
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
