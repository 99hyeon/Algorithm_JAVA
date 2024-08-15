package BJ_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int Y = 0;
        int M = 0;

        for(int i = 0; i < num; i++){
            double tmp = Integer.parseInt(st.nextToken());

            if(tmp % 30 == 0){
                Y +=((tmp/30) + 1)*10;
            }else{
                Y += Math.ceil(tmp / 30)*10;
            }

            if(tmp % 60 == 0){
                M +=((tmp/60) + 1)*15;
            }else{
                M += Math.ceil(tmp / 60)*15;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(Y == M){
            sb.append("Y M").append(" ").append(Y);
        } else if(Y > M){
            sb.append("M").append(" ").append(M);
        } else{
            sb.append("Y").append(" ").append(Y);
        }

        System.out.println(sb);
    }
}
