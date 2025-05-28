package BJ_0x05_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[num];
        for(int i = num - 1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.add(arr[i]);
                result[i] = -1;
            }else{
                if(stack.peek() <= arr[i]){
                    while(!stack.isEmpty() && stack.peek() <= arr[i]){
                        stack.pop();
                    }
                }

                if(stack.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = stack.peek();
                }

                stack.add(arr[i]);
            }
        }

        for(int i = 0; i < num; i++){
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

}
