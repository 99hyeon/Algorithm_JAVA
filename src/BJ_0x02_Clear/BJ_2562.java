package BJ_0x02_Clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int value = 0;
        for(int i = 0; i < 9; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp > max){
                value = i+1;
                max = tmp;
            }
        }

        System.out.println(max + "\n" + value);

    }
}
