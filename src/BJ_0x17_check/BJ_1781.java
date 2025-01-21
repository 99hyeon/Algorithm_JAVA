package BJ_0x17_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Problem> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            priorityQueue.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> ramenSum = new PriorityQueue<>();
        while(!priorityQueue.isEmpty()){
            Problem poll = priorityQueue.poll();

            ramenSum.add(poll.ramen);
            if(ramenSum.size() > poll.deadLine){
                ramenSum.poll();
            }
        }

        int sum = 0;
        while(!ramenSum.isEmpty()){
            sum += ramenSum.poll();
        }

        System.out.println(sum);

    }

    static class Problem implements Comparable<Problem>{
        int deadLine;
        int ramen;

        public Problem(int deadLine, int ramen) {
            this.deadLine = deadLine;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Problem problem){
            if(this.deadLine == problem.deadLine){
                return problem.ramen - this.ramen;
            }else{
                return this.deadLine - problem.deadLine;
            }
        }
    }
}

/**
 * 다시
 */
