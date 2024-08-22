package BJ_0x08_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int countOpen = 0;
        int countAll = 0;
        boolean check = true;
        for(int i = 0; i < input.length(); i ++){
            char tmp = input.charAt(i);

            if(tmp == '('){
                stack.push(tmp);
                countOpen++;
                check = true;
            }else{
                if(check){
                    stack.pop();
                    countOpen--;
                    countAll += countOpen;
                }else{
                    countAll++;
                    countOpen--;
                    stack.pop();
                }
                check = false;
            }
        }

        System.out.println(countAll);
    }
}
