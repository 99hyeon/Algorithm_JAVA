package BJ_0x13_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16401 {

    static int snackNum;
    static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nephewNum = Integer.parseInt(st.nextToken());
        snackNum = Integer.parseInt(st.nextToken());
        snacks = new int[snackNum];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < snackNum; i++){
            snacks[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(snacks);

        int maxLength = 0;
        int left = 1;
        int right = snacks[snackNum - 1];

        while(left <= right){
            int mid = (left + right) / 2;

            int cnt = count(mid);
            if(cnt >= nephewNum){
                maxLength = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        System.out.println(maxLength);
    }

    static int count(int snackLength){
        int cnt = 0;

        for(int i = 0; i < snackNum; i++){
            if(snacks[i] >= snackLength){
                cnt += snacks[i] / snackLength;
            }
        }

        return  cnt;
    }
}

/**
 * 다시
 */
