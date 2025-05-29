package BJ_0x06_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        while(num > 0){
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            switch (order){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.getLast()).append("\n");
                    }
                    break;
            }

            num--;
        }

        System.out.println(sb);
    }
}
