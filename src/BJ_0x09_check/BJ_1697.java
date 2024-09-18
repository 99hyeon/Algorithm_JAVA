package BJ_0x09_check;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] seconds = new int[200001];
        for(int i = 0; i < seconds.length; i++){
            seconds[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        seconds[N] = 0;

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            int[] dx = {-1, 1, 2};
            int next = tmp;

            boolean check = false;
            for(int i = 0; i < 3; i++){
                if(i == 2){
                    next = tmp*dx[i];
                }else
                    next = tmp + dx[i];

                if(next < 0 || next >= seconds.length)
                    continue;

                if(seconds[next] != -1)
                    continue;

                else{
                    seconds[next] = seconds[tmp] + 1;
                    queue.add(next);

                    if(next == K){
                        check = true;
                        break;
                    }
                }
            }

            if(check)
                break;
        }

        System.out.println(seconds[K]);
    }
}
