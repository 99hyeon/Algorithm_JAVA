package BJ_0x02_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++){
            int tmp = Integer.parseInt(st.nextToken());

            if(tmp < num){
                sb.append(tmp).append(" ");
            }
        }
        br.close();

        System.out.println(sb);
    }
}

/**
 * 알고리즘을 한동안 손놓고 있다가 추천받은 바킹독 알고 커리로 다시 시작하려 합니당. 허허
 * 첫 문제는 그래도 bufferedreader, stringtokenizer, stringbuilder를 사용했고
 * 저 친구들을 새로 알게 됐던 그때가 새록새록 생각이 났던 그런 허허
 * 첫 문제는 가볍게 통과
 * 오예~~!
 */
