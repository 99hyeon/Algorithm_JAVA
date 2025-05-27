package BJ_0x02_clear;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_2441 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= num; i++){
            for(int j = 1; j < i ; j++){
                bw.write(" ");
            }
            for(int j = 0; j <= num-i ; j++){
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}
