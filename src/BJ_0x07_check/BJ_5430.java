package BJ_0x07_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            String function = br.readLine();

            int num = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for(int j = 0; j < num; j++){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(function, deque);
        }

        br.close();
        System.out.println(sb);
    }

    public static void AC(String function, Deque<Integer> deque){
        boolean order = true;   //true == 맨 앞, false == 맨 뒤
        boolean error = true;
        for(int j = 0; j < function.length(); j++){
            char tmp = function.charAt(j);

            if(tmp == 'R'){
                order = !order;
            }else if(tmp == 'D'){
                if(!deque.isEmpty()){
                    if(order){
                        deque.removeFirst();
                    }else{
                        deque.removeLast();
                    }
                }else{
                    error = false;
                    break;
                }
            }
        }

        if(error == false){
            sb.append("error").append("\n");
        }else{
            if(deque.size() == 0){
                sb.append("[]").append("\n");
            }else if(order){
                sb.append("[");
                sb.append(deque.removeFirst());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.removeFirst());
                }
                sb.append("]").append("\n");
            }else{
                sb.append("[");
                sb.append(deque.removeLast());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.removeLast());
                }
                sb.append("]").append("\n");
            }
        }
    }
}


/**
 * 문제 설명 요약
 *
 *  R : 배열 수의 순서 뒤집기
 *  D : 첫번째 수 버리기(배열 비어있을 경우 에러 발생)
 *
 */