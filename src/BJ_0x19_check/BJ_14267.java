package BJ_0x19_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14267 {

    static int[] parent;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            parent[i] = Integer.parseInt(st.nextToken());
        }

        score = new int[n + 1];
        while(m > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            score[i] += w;
            m--;
        }

        for(int i = 2; i <= n; i++){
            score[i] += score[parent[i]];
        }

        for(int i = 1; i <= n; i++){
            sb.append(score[i]).append(" ");
        }

        System.out.println(sb);
    }
}
