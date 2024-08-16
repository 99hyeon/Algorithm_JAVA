package BJ_0x02_Clear;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_2446 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = num; i >= 1; i--){
            for(int j = 1; j <= num-i ; j++){
                bw.write(" ");
            }
            for(int j = 1; j <= (2*i - 1); j++){
                bw.write("*");
            }
//            for(int j = 1; j <= num-i ; j++){
//                bw.write(" ");
//            }
            bw.write("\n");
        }

        for(int i = 2; i <= num; i++){
            for(int j = 1; j <= num-i ; j++){
                bw.write(" ");
            }
            for(int j = 1; j <= (2*i - 1); j++){
                bw.write("*");
            }
//            for(int j = 1; j <= num-i ; j++){
//                bw.write(" ");
//            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

/**
 * 뒤에 공백은 출력하는 것이 아니었다...ㅎㅎ
 * 주석처리된 부분을 같이 실행시키면 출력 형식이 잘못되었다고 뜬다..
 */