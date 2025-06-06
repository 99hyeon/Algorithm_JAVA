package BJ_0x02_clear;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_2442 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int max = 2*num - 1;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= num; i++){
            for(int j = 0; j <= (num-1)-i; j++){
                bw.write(" ");
            }
            for(int j = 0; j < (2*i - 1); j++){
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
