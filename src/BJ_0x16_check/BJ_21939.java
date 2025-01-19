package BJ_0x16_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_21939 {
    static class Problem implements Comparable<Problem>{
        int level;
        int number;

        public Problem(int level, int number) {
            this.level = level;
            this.number = number;
        }

        @Override
        public int compareTo(Problem problem){
            if(level == problem.level){
                return Integer.compare(number, problem.number);
            }else{
                return Integer.compare(level, problem.level);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> treeSet = new TreeSet<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            treeSet.add(new Problem(level, number));
            hashMap.put(number, level);
        }

        int P = Integer.parseInt(br.readLine());
        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "add" :
                    int number = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    treeSet.add(new Problem(level, number));
                    hashMap.put(number, level);
                    break;
                case "recommend" :
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 1){
                        sb.append(treeSet.last().number).append("\n");
                    }else{
                        sb.append(treeSet.first().number).append("\n");
                    }
                    break;
                case "solved" :
                    int solveNum = Integer.parseInt(st.nextToken());
                    int solveLevel = hashMap.get(solveNum);

                    hashMap.remove(solveNum);
                    treeSet.remove(new Problem(solveLevel, solveNum));
                    break;
                default:
                    break;
            }
        }
        br.close();

        System.out.println(sb);
    }
}
