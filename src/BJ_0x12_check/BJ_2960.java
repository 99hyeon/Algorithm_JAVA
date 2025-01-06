package BJ_0x12_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] numCheck = new boolean[N + 1];
        int cnt = 0;
        int P = 2;

        while(true){
            for(int i = 1; i < N; i++){
                int currentNum = P * i;

                if(currentNum > N){
                    break;
                }else{
                    if(!numCheck[currentNum]){
                        numCheck[currentNum] = true;
                        cnt++;
                    }
                }

                if(cnt == K){
                    System.out.println(currentNum);
                    System.exit(0);
                }
            }

            for(int i = P + 1; i <= N; i++){
                if(!numCheck[i]){
                    P = i;
                    break;
                }
            }
        }


    }
}
