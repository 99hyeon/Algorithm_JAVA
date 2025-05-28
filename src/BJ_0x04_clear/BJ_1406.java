package BJ_0x04_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String string = br.readLine();
        for(int i = 0; i < string.length(); i++){
            leftStack.add(string.charAt(i));
        }

        int commandNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < commandNum; i++){
            String command = br.readLine();
            Character first = command.charAt(0);

            if(first == 'L'){
                if(!leftStack.isEmpty()){
                    rightStack.add(leftStack.pop());
                }
            } else if(first == 'D'){
                if(!rightStack.isEmpty()){
                    leftStack.add(rightStack.pop());
                }
            } else if(first == 'B'){
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }
            } else if(first == 'P'){
                leftStack.add(command.charAt(2));
            }
        }

        while(!leftStack.isEmpty()){
            sb.append(leftStack.pop());
        }
        sb.reverse();

        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}
