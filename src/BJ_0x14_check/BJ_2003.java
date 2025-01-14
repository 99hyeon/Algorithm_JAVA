package BJ_0x14_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = array[start];
        int cnt = 0;
        while(true){
            if(sum == M){
                cnt++;
                sum -= array[start];
                start += 1;
            }else if(sum < M){
                end += 1;

                if(end >= N){
                    break;
                }
                sum += array[end];
            }else{
                sum -= array[start];
                start += 1;
            }
        }

        System.out.println(cnt);
    }
}
