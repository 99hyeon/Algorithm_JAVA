package BJ_0x13_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] ans = new int[3];
        long min = Long.MAX_VALUE;
        for(int i = 0; i < num - 2; i++){
            int left = i + 1;
            int right = num - 1;

            while(left < right){
                long sum = (long)arr[i] + (long)arr[left] + (long)arr[right];

                if(Math.abs(sum) < min){
                    min = Math.abs(sum);

                    ans[0] = arr[i];
                    ans[1] = arr[left];
                    ans[2] = arr[right];

                    if(sum == 0){
                        break;
                    }
                }

                if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }

        System.out.println(ans[0] +" "+ ans[1] +" "+ ans[2]);

    }
}
