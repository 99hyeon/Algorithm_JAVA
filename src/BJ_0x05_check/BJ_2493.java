package BJ_0x05_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= num; i++){
            int top = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                int[] tmpArr = new int[2];
                tmpArr[0] = top;
                tmpArr[1] = i;
                stack.push(tmpArr);
                sb.append("0").append(" ");
            }
            else{
                while(true){

                    if(stack.isEmpty()){
                        int[] arr = new int[2];
                        arr[0] = top;
                        arr[1] = i;
                        stack.push(arr);
                        sb.append("0").append(" ");
                        break;
                    }else{
                        int[] tmpArr = stack.peek();

                        if(tmpArr[0] > top){
                            sb.append(tmpArr[1]).append(" ");
                            int[] arr = new int[2];
                            arr[0] = top;
                            arr[1] = i;
                            stack.push(arr);
                            break;
                        }else{
                            stack.pop();
                        }
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
