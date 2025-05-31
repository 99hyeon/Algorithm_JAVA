package BJ_0x08_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack;
        String tmp = br.readLine();
        while(!tmp.equals(".")){
            stack = new Stack<>();

            boolean balance = true;
            for(int i = 0; i < tmp.length(); i++){
                char character = tmp.charAt(i);

                if(character == '(' || character == '['){
                    stack.push(character);
                }else if(character == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        balance = false;
                        break;
                    }
                }else if(character == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        balance = false;
                        break;
                    }
                }else
                    continue;
            }

            if(!stack.isEmpty() || !balance){
                sb.append("no").append("\n");
            } else if(balance == true){
                sb.append("yes").append("\n");
            }

            tmp = br.readLine();
        }

        System.out.println(sb);
    }
}
