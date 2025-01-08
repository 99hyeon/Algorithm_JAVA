package BJ_0x12_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int jm = Integer.parseInt(st.nextToken());
        int hs = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < num; i++){
            list.add(i);
        }

        int round = 0;
        while(true) {
            round++;

            jm = jm / 2 + jm % 2;
            hs = hs / 2 + hs % 2;

            if(jm == hs){
                break;
            }
        }

        System.out.println(round);
    }
}
