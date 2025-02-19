package BJ_0x17_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        if(N == 1){
            sum = 0;
        }else{
            while(priorityQueue.size() > 1){
                int first = priorityQueue.poll();
                int second = priorityQueue.poll();
                int tmp = first + second;

                sum += tmp;
                priorityQueue.add(tmp);
            }

        }

        System.out.println(sum);
    }
}
