package BJ_0x12_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < testNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int[] array = new int[num];
            for(int j = 0; j < num; j++){
                array[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for(int j = 0; j < num - 1; j++){
                for(int k = j+1; k < num; k++){
                    sum += gcd(Math.max(array[j], array[k]), Math.min(array[j], array[k]));
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static int gcd(int big, int small){
        if(big == small){
            return big;
        }

        if(small == 0){
            return big;
        }

        return gcd(small, big % small);
    }
}
