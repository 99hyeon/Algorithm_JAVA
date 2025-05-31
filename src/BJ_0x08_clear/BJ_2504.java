package BJ_0x08_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();
        Stack<Character> stack = new Stack<>();

        int multipleTmp = 1;
        int count = 0;

        boolean check = true;
        for(int i = 0; i < sentence.length(); i++){
            char tmpChar = sentence.charAt(i);

            if(tmpChar == '('){
                stack.push(tmpChar);
                multipleTmp *= 2;

            } else if(tmpChar == '['){
                stack.push(tmpChar);
                multipleTmp *= 3;

            } else if(tmpChar == ')'){
                if(stack.isEmpty() || stack.peek() == '['){    //입력이 올바르지 못한 괄호열일 경우
                    check = false;
                    break;
                }else{
                    if(sentence.charAt(i-1) == '('){
                        count += multipleTmp;
                    }

                    multipleTmp /= 2;
                    stack.pop();
                }
            } else {
                if(stack.isEmpty() || stack.peek() == '('){    //입력이 올바르지 못한 괄호열일 경우
                    check = false;
                    break;
                }else{
                    if(sentence.charAt(i-1) == '['){
                        count += multipleTmp;
                    }

                    multipleTmp /= 3;
                    stack.pop();
                }
            }
        }

        if(!check || !stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(count);
        }
    }
}

/**
 * 힌트 : 분배법칙 활용
 *
 * ++런타임 에러(EmptyStack)이 계속 뜬 이유 == if조건문에 stack.peek를 하기 전에 stack.isEmpty를 먼저 체크해야하는데
 * 순서를 반대로 해서 EmptyStack 런타임 에러가 뜸.
 * 오호.... 그것도 모르거 if 중첩문 너무 많이 써서 런타임 에러 뜬 줄 알았는데
 * EmptyStack글자를 흐린눈 하고 있었다..
 * 허허 어떤 에러인지 괄호안 내용도 앞으로 잘 봐야겠다..ㅎ
 */
