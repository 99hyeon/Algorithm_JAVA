package BJ_0x14_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        int[] check = new int[100000 + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        check[array[end]]++;
        int max = Integer.MIN_VALUE;
        while(end < N){
            if(end == N - 1){
                max = Math.max(max, end - start + 1);
                break;
            }else if(check[array[end + 1]] == K){
                max = Math.max(max, end - start + 1);
                check[array[start]]--;
                start++;
            }else{
                end++;
                check[array[end]]++;
            }
        }

        System.out.println(max);
    }
}
