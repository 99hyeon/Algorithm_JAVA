package BJ_0x11_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < testNum; i++){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] numbers = new int[num];
            for(int j = 0; j < num; j++){
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            long result = 0;
            for(int j = num-1; j >= 0; j--){
                if(numbers[j] > max){
                    max = numbers[j];
                }else if(numbers[j] < max){
                    result += (max - numbers[j]);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
