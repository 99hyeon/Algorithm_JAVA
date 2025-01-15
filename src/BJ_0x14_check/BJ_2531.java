package BJ_0x14_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] count = new int[d + 1];

        int[] sushi = new int[N];
        for(int i = 0; i < N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        boolean checkRound = false;
        while(true){
            if(cnt == k){
                if(set.contains(c)){
                    max = Math.max(max, set.size());
                }else{
                    max = Math.max(max, set.size() + 1);
                }

                if(count[sushi[start]] == 1){
                   set.remove(sushi[start]);
                }

                count[sushi[start]]--;
                start++;
                cnt--;

            }else{
                count[sushi[end]]++;
                set.add(sushi[end]);
                end++;
                cnt++;
            }

            if(end == N){
                checkRound = true;
                end = 0;
            }

            if(start == N){
                start = 0;
            }

            if(start == 1 && checkRound){
                break;
            }

            if(max == k + 1){
                break;
            }
        }

        System.out.println(max);
    }
}

/**
 * 다시
 * 이유 : 코드 더 깔끔하게 하기
 */
