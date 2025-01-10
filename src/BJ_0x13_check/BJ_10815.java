package BJ_0x13_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10815 {

    static int[] sgNums;
    static int sg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        sg = Integer.parseInt(br.readLine());
        sgNums = new int[sg];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < sg; i++){
            sgNums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sgNums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int tmp = Integer.parseInt(st.nextToken());

            sb.append(find(tmp)).append(" ");
        }

        System.out.println(sb);
    }

    static int find(int num){
        int left = 0;
        int right = sg - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(sgNums[mid] == num){
                return  1;
            }else if(num < sgNums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return 0;
    }
}
