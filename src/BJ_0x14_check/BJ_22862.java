package BJ_0x14_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[S];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int oddNumCnt = 0;
        int maxLength = Integer.MIN_VALUE;
        while(end < S){
            int tmpNum = array[end];

            if(tmpNum % 2 == 1){
                oddNumCnt++;
            }

            if(oddNumCnt > K){
                int length = end - start + 1 - oddNumCnt;
                maxLength = Math.max(maxLength, length);

                while(array[start] % 2 == 0){
                    start++;
                }
                oddNumCnt--;
                start++;
            }
            end++;
        }
        int length = end - start - oddNumCnt;
        maxLength = Math.max(maxLength, length);

        System.out.println(maxLength);
    }
}

/**
 * 다시
 * 이유 : 코드 더 깔끔하게 해보기
 */
