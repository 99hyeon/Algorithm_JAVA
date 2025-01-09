package BJ_0x12_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        br.close();

        List<Integer> list = new ArrayList<>();
        list.add(0);

        int cnt = 0;
        int num = 1;
        for(int i = 0; i < B; i++){
            list.add(num);
            cnt++;

            if(num == cnt){
                num++;
                cnt = 0;
            }
        }

        int sum = 0;
        for(int i = A; i <= B; i++){
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}
