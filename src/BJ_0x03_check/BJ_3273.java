package BJ_0x03_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.parseInt(br.readLine());
        Arrays.parallelSort(arr);   //Arrays.sort사용하면 컴파일 에러가 뜸

        int count = 0;
        int lp = 0;
        int rp = num-1;

        while(lp < rp){
            if(arr[lp] + arr[rp] == result){
                count++;
            }

            if(arr[lp] + arr[rp] > result){
                rp--;
            }else if(arr[lp] + arr[rp] <= result){
                lp++;
            }
        }

        System.out.println(count);
    }
}

/**
 * sort는 단일 쓰레드
 * parallelSort는 멀티 쓰레드
 *
 * 따라서 정렬할 원소가 많을 경우 parallelSort를 사용하는 것이 성능이 더 좋다(약 5000개 이상부터)
 */
