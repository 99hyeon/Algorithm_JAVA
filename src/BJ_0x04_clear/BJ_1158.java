package BJ_0x04_clear;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> people = new LinkedList<>();

        for(int i = 0; i < N; i++){
            people.add(i+1);
        }

        int order = K-1;

        LinkedList<Integer> tmp = new LinkedList<>();
        while(people.size() > 0){
            if(order < people.size()){
                tmp.add(people.get(order));
                people.remove(order);
                order += (K-1);
            }
            else if(order >= people.size()){
                order -= people.size();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < tmp.size(); i++){
            if(i == tmp.size()-1){
                sb.append(tmp.get(i));
            }else{
                sb.append(tmp.get(i)).append(",").append(" ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
