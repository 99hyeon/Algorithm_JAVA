package BJ_0x05_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < num; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp == 0 && !stack.isEmpty()){
                stack.pop();
            }else if(tmp != 0){
                stack.push(tmp);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);

    }
}
