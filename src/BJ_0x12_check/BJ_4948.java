package BJ_0x12_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                break;
            }

            boolean[] check = new boolean[2*num + 1];
            for(int i = 2; i <= num; i++){
                int j = num / i;

                while(i * j <= num * 2){
                    check[i*j] = true;
                    j++;
                }
            }

            int count = 0;
            for(int i = num; i <= num * 2; i++){
                if(i == 1){
                    continue;
                }else if(!check[i]){
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
