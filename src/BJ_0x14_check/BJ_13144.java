package BJ_0x14_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;
        int start = 0;
        int end = 0;
        int[] check = new int[100000 + 1];
        while(start < N){
            while(end < N && check[array[end]] <= 0){
                check[array[end]]++;
                end++;
            }

            cnt += (long)end - (long)start;
            check[array[start]]--;
            start++;

        }

        System.out.println(cnt);
    }
}
