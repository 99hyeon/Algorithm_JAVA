package BJ_0x02_clear;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_2445 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= num; i++){
            for(int j = 0; j < i; j++){
                bw.write("*");
            }
            for(int j = 0; j < (2*num - 2*i); j++){
                bw.write(" ");
            }
            for(int j = 0; j < i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        for(int i = num-1; i >= 1; i--){
            for(int j = 0; j < i; j++){
                bw.write("*");
            }
            for(int j = 0; j < (2*num - 2*i); j++){
                bw.write(" ");
            }
            for(int j = 0; j < i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
