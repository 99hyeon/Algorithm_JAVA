package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] array = new int[num][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            array[i][0] = Integer.parseInt(st.nextToken());
        }

        array[0][1] = array[0][0];
        for(int i = 1; i < num; i++){
            int max = array[i][0];
            for(int j = 0; j < i; j++){
                if(array[i][0] > array[j][0]){
                    max = Math.max(max, array[i][0] + array[j][1]);
                }
            }
            array[i][1] = max;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < num; i++){
            max = Math.max(max, array[i][1]);
        }

        System.out.println(max);
    }
}
