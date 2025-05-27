package BJ_0x03_clear;

import java.io.*;

public class BJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 1;
        int[] numArr = new int[10];
        for(int i = 0; i < 10; i++){
            numArr[i] = 0;
        }

        for(int i = 0; i < 3; i++){
            result *= Integer.parseInt(br.readLine());
        }


        String tmpNum = Integer.toString(result);
        int[] tmpArr = new int[tmpNum.length()];

        for(int i = 0; i < tmpNum.length(); i++){
            tmpArr[i] = tmpNum.charAt(i) - '0';
        }


        for(int i = 0; i < tmpArr.length; i++){
            numArr[tmpArr[i]]++;
        }


        for(int i = 0; i < numArr.length; i++){
            System.out.println(numArr[i]);
        }
    }
}
