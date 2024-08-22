package BJ_0x08_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_3986 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0 ; i < num; i++){
            String tmp = br.readLine();

            if(goodWord(tmp)){
                count++;
            }
        }
        br.close();

        System.out.println(count);
    }

    static boolean goodWord(String words){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < words.length(); i++){
            char tmp = words.charAt(i);

            if(stack.isEmpty()){
                stack.push(tmp);
            }else{
                if(stack.peek() == tmp){
                    stack.pop();
                }else{
                    stack.push(tmp);
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
