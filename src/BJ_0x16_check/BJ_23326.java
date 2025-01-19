package BJ_0x16_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_23326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 1){
                treeSet.add(i + 1);
            }
        }

        int currentLocation = 1;
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());

            if(query == 1){
                int tmpNum = Integer.parseInt(st.nextToken());
                if(treeSet.contains(tmpNum)){
                    treeSet.remove(tmpNum);
                }else{
                    treeSet.add(tmpNum);
                }
            }else if(query == 2){
                int move = Integer.parseInt(st.nextToken()) % N;
                currentLocation += move;

                if(currentLocation > N){
                    currentLocation %= N;
                }
            }else{
                Integer nextLocation = treeSet.higher(currentLocation - 1);
                if(nextLocation != null){
                    sb.append(nextLocation - currentLocation).append("\n");
                }else if(!treeSet.isEmpty()){
                    nextLocation = treeSet.first();
                    sb.append(nextLocation + N - currentLocation).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
