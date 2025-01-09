package BJ_0x12_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int firstRing = Integer.parseInt(st.nextToken());

        for(int i = 1; i < num; i++){
            int nextRing = Integer.parseInt(st.nextToken());

            int divide = find(firstRing, nextRing);
            sb.append(firstRing/divide).append("/").append(nextRing/divide).append("\n");
        }

        System.out.println(sb);
    }

    static int find(int a, int b){
        int remain = 0;

        while(b != 0){
            remain = a % b;
            a = b;
            b = remain;
        }

        return a;
    }
}
