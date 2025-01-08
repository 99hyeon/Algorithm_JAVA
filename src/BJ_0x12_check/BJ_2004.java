package BJ_0x12_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long fiveCnt = count(n, 5) - count(m, 5) - count(n - m, 5);
        long twoCnt = count(n, 2) - count(m, 2) - count(n - m, 2);

        System.out.println(Math.min(fiveCnt, twoCnt));
    }

    static long count(int num, int divide){
        long cnt = 0;

        while(true){
            if(num / divide < 1){
                break;
            }else{
                num = num / divide;
                cnt += num;
            }
        }

        return  cnt;
    }
}

/**
 * 다시
 */