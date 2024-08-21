package BJ_0x07_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int dequeSize = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        Queue<Integer> pullNum = new LinkedList<>();  //뽑을 숫자
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            pullNum.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= dequeSize; i++){
            deque.add(i);
        }

        int count = 0;
        while(!pullNum.isEmpty()){
            int tmpNum = pullNum.peek();

            if(deque.peek() == tmpNum){
                deque.remove();
                pullNum.remove();
            }else if(deque.getLast() == tmpNum){
                deque.removeLast();
                pullNum.remove();
                count++;
            }else{
                int location = deque.indexOf(tmpNum);

                int half = 0;
                if(deque.size() % 2 == 0){
                    half = deque.size() / 2 - 1;
                }else{
                    half = deque.size() / 2;
                }

                if(location > half){
                    int tmp = deque.removeLast();
                    deque.addFirst(tmp);
                    count++;
                }else{
                    int tmp = deque.removeFirst();
                    deque.addLast(tmp);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
