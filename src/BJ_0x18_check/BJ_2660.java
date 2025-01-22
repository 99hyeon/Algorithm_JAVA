package BJ_0x18_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j)
                    array[i][j] = 987654321;
            }
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == -1 && end == -1)
                break;

            array[start - 1][end - 1] = 1;
            array[end - 1][start - 1] = 1;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(array[i][j] > array[i][k] + array[k][j]){
                        array[i][j] = array[i][k] + array[k][j];
                    }
                }
            }
        }

        int[] max = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(max[i] != 987654321){
                    max[i] = Math.max(max[i], array[i][j]);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(max[i] < min){
                list.clear();
                list.add(i + 1);
                min = max[i];
            }else if(max[i] == min){
                list.add(i + 1);
            }
        }

        Collections.sort(list);
        sb.append(min + " " + list.size()).append("\n");
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);

    }
}

/**
 * 다시
 * 플로이드 와샬
 */
