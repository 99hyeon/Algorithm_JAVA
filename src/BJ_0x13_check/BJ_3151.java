package BJ_0x13_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }
        Arrays.sort(arr);

        long cnt = 0;
        for(int i = 0; i < num - 1; i++){
            if(arr[i] > 0){
                break;
            }

            int left = i+1;
            int right = num - 1;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == 0){
                    if(arr[left] == arr[right]){
                        int n = right - left + 1;

                        cnt += ((long) n *(n - 1)) / 2;
                        break;
                    }else{
                        int leftCnt = left + 1;
                        int rightCnt = right - 1;

                        while(arr[left] == arr[leftCnt]){
                            leftCnt += 1;
                        }

                        while(arr[right] == arr[rightCnt]){
                            rightCnt -= 1;
                        }

                        cnt += (long) (leftCnt - left) * (right - rightCnt);

                        left = leftCnt;
                        right = rightCnt;
                    }
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }

        System.out.println(cnt);
    }
}

/**
 * 다시
 */
