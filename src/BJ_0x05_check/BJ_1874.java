package BJ_0x05_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int maxPush = 0;
        boolean check = true;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < num; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(stack.isEmpty() || stack.peek() < tmp){
                for(int j = maxPush + 1; j <= tmp; j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                maxPush = tmp;
                stack.pop();
                sb.append("-").append("\n");
            } else if(stack.peek() > tmp){
                check = false;
            } else if(stack.peek() == tmp){
                stack.pop();
                sb.append("-").append("\n");
            }
            else{
                check = false;
            }
        }

        if(check == false){
            System.out.println("NO");
        }else{
            System.out.println(sb);
        }
    }
}

/**
 * 문제 이해를 못하겠다.
 * 내가 이해하기에 이 문제의 조건은
 * 스택에 push를 할 때 오름차순이 되게하는 것 즉 수가 오름차순일 때 stack에 push를 하는 것으로 이해했다.
 * 그럼 pop은 언제하는 거지?
 * 그냥 이해 안됨
 *
 * 구글링을 통해 이해하고 왔다.
 * 즉 스택에는 N까지의 수열 예를 들어
 * N이 8이라면 1~8까지의 숫자를 넣고 빼면서
 * 주어진 수열을 만들 수 있는지 묻는 문제!!
 * 따라서 예제에 보여진 수열을 내가 활용하는 것이 아닌
 * 내가 예제 에 주어진 수열을 만들 수 있는지 묻는 그런 문제였다!
 */