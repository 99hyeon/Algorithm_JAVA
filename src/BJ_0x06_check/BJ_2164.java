package BJ_0x06_check;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= num; i++){
            q.add(i);
        }

        boolean check = true;
        while(q.size()>1){
            if(check){
                q.remove();
                check = false;
            }else{
                q.add(q.remove());
                check = true;
            }
        }

        System.out.println(q.peek());
    }
}
