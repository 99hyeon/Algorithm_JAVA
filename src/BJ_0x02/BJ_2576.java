package BJ_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 7; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp % 2 == 1){
                min = Math.min(min, tmp);
                result += tmp;
            }
        }

        if(result == 0){
            System.out.println("-1");
        }else
            System.out.println(result + "\n" + min);
    }
}
