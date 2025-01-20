package BJ_0x17_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                int tmp = priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
                sb.append(tmp).append("\n");
            }else{
                priorityQueue.add(num);
            }
        }

        System.out.println(sb);
    }
}
