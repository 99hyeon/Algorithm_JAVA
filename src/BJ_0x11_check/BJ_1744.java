package BJ_0x11_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> postivieNum = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeNum = new PriorityQueue<>();

        for(int i = 0; i < num; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp > 0){
                postivieNum.add(tmp);
            }else{
                negativeNum.add(tmp);
            }
        }

        int result = 0;
        while(!postivieNum.isEmpty()){
            int first = postivieNum.poll();

            if(first == 1 || postivieNum.isEmpty()){
                result += first;
            }else {
                int second = postivieNum.poll();

                if(second == 1){
                    result += (first + second);
                }else{
                    result += (first * second);
                }
            }
        }

        while(!negativeNum.isEmpty()){
            int first = negativeNum.poll();

            if(!negativeNum.isEmpty()){
                result += (first * negativeNum.poll());
            }else{
                result += first;
            }
        }

        System.out.println(result);
    }
}
