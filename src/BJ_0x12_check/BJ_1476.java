package BJ_0x12_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 0;
        int e = 0;
        int s = 0;
        int m = 0;
        while(true){
            year++;
            e++;
            s++;
            m++;

            if(e == 16){
                e = 1;
            }
            if(s == 29){
                s = 1;
            }
            if(m == 20){
                m = 1;
            }

            if(e == E && s == S && m == M){
                System.out.println(year);
                break;
            }
        }
    }
}
