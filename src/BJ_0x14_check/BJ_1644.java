package BJ_0x14_check;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean[] numbers = new boolean[N + 1];

        if(N == 1){
            System.out.println(0);
            System.exit(0);
        }

        for(int i = 2; i <= N; i++){
            int j = 2;

            while(i * j <= N){
                numbers[i * j] = true;
                j += 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= N; i++){
            if(!numbers[i]){
                list.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int sum = list.get(start);
        while(true){
            if(sum == N){
                cnt++;
                sum -= list.get(start);
                start += 1;
            }else if(sum < N){
                end += 1;

                if(end < list.size()){
                    sum += list.get(end);
                }else{
                    break;
                }
            }else {
                sum -= list.get(start);
                start += 1;
            }
        }

        System.out.println(cnt);
    }
}
