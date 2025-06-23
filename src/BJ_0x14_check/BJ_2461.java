package BJ_0x14_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2461 {

    public static class People implements Comparable<People> {

        int classIdx;
        int ability;

        public People(int classIdx, int ability) {
            this.classIdx = classIdx;
            this.ability = ability;
        }

        @Override
        public int compareTo(People o) {
            return this.ability - o.ability;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] queue = new PriorityQueue[N];

        PriorityQueue<People> compare = new PriorityQueue<>();
        People maxPeople = new People(-1, 0);
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            queue[i] = new PriorityQueue<>();
            for(int j = 0; j < M; j++){
                queue[i].add(Integer.parseInt(st.nextToken()));
            }
            int tmpPoll = queue[i].poll();
            compare.add(new People(i, tmpPoll));
            if(tmpPoll > maxPeople.ability){
                maxPeople = new People(i, tmpPoll);
                if(maxPeople.classIdx != -1){
                    queue[maxPeople.classIdx].add(maxPeople.ability);
                }
            }
        }


        int min = Integer.MAX_VALUE;
        while(!compare.isEmpty()){
            People minPeople = compare.poll();

            min = Math.min(maxPeople.ability - minPeople.ability, min);

            if(min == 0 || queue[minPeople.classIdx].isEmpty()){
                break;
            }

            int tmp = queue[minPeople.classIdx].peek();
            if(tmp > maxPeople.ability){
                queue[maxPeople.classIdx].add(maxPeople.ability);
                maxPeople = new People(minPeople.classIdx, tmp);
            }

            compare.add(new People(minPeople.classIdx, queue[minPeople.classIdx].poll()));
        }


        System.out.println(min);

    }

}
