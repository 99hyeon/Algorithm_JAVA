package BJ_0x09_check;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seconds = new int[200001];

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        int[] dx = {-1, 1, 2};

        queue.add(N);
        seconds[N] = 1;
        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i = 0; i < 3; i++){
                int next = 0;
                if(i == 2){
                    next = current * dx[i];
                }else{
                    next = current + dx[i];
                }

                if(next >= seconds.length || next < 0)
                    continue;

                if(seconds[next] == 0){
                    if(i == 2){
                        seconds[next] = seconds[current];
                    }else{
                        seconds[next] = seconds[current] + 1;
                    }
                    queue.add(next);
                }else if(seconds[next] > seconds[current] + 1 && i != 2){
                    seconds[next] = seconds[current] + 1;
                    queue.add(next);
                }else if(seconds[next] > seconds[current] && i == 2){
                    seconds[next] = seconds[current];
                    queue.add(next);
                }
            }
        }

        System.out.println(seconds[K] - 1);
    }
}
