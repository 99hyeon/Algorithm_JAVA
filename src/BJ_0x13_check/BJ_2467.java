package BJ_0x13_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < num - 1; i++){
            int left = i + 1;
            int right = num - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                int sum = array[i] + array[mid];
                if(Math.abs(sum) < min){
                    min = Math.abs(sum);

                    answer[0] = array[i];
                    answer[1] = array[mid];
                }else if(sum < 0){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}

/**
 * 다시
 */