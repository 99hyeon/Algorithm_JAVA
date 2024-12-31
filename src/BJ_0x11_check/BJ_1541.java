package BJ_0x11_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String oneLine = br.readLine();
        String[] splits = oneLine.split("-");

        int[] addition = new int[splits.length];
        for(int i = 0; i < splits.length; i++){
            String[] tokens = splits[i].split("\\+");

            for(int j = 0; j < tokens.length; j++){
                addition[i] += Integer.parseInt(tokens[j]);
            }
        }

        int result = addition[0];
        for(int i = 1; i < addition.length; i++){
            result -= addition[i];
        }

        System.out.println(result);
    }
}

/**
 * 다시하기
 */
