package BJ_0x05_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < num; i++){
            int target = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()){
                if(!stack.isEmpty() && stack.peek() <= target){
                    stack.pop();
                }else{
                    break;
                }
            }

            sum += stack.size();
            stack.push(target);
        }

        System.out.println(sum);
    }
}

/**
 * 다시
 */
