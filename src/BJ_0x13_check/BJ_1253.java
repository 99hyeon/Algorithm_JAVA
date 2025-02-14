package BJ_0x13_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int cnt = 0;
        for(int i = 0; i < N; i++){
            int current = list.get(i);

            int left = i == 0 ? 1 : 0;
            int right = i == N - 1 ? N - 2 : N - 1;
            while(left < right){
                int sum = list.get(left) + list.get(right);

                if(sum == current){
                    cnt++;
                    break;
                }else if(sum > current){
                    right = right - 1 == i ? right - 2 : right - 1;
                }else{
                    left = left + 1 == i ? left + 2 : left + 1;
                }
            }
        }

        System.out.println(cnt);
    }
}
