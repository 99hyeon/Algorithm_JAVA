package BJ_0x07_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }else if(command.equals("push_back")){
                deque.add(Integer.parseInt(st.nextToken()));
            }else if(command.equals("pop_front")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.pollFirst()).append("\n");
                }
            }else if(command.equals("pop_back")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.pollLast()).append("\n");
                }
            }else if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }else if(command.equals("empty")){
                if(deque.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(command.equals("front")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.peekFirst()).append("\n");
                }
            }else if(command.equals("back")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
