package BJ_0x06_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String tmp = st.nextToken();

            switch (tmp){
                case "push":
                    int tmpX = Integer.parseInt(st.nextToken());
                    queue.add(tmpX);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(queue.poll()).append("\n");
//                        queue.remove();
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append("1").append("\n");
                    }else{
                        sb.append("0").append("\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(queue.getLast()).append("\n");
                    }
                    break;
            }
        }

        br.close();
        System.out.println(sb);
    }
}
