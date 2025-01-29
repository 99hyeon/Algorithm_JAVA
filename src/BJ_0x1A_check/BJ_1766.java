package BJ_0x1A_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeSet<Integer> treeSet = new TreeSet<>();

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        int[] edgeCnt = new int[N + 1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            edgeCnt[v]++;
        }

        for(int i = 1; i <= N; i++){
            if(edgeCnt[i] == 0){
                treeSet.add(i);
            }
        }

        while(!treeSet.isEmpty()){
            int poll = treeSet.first();
            treeSet.remove(poll);
            sb.append(poll).append(" ");

            for(int i = 0; i < list.get(poll).size(); i++){
                int tmp = list.get(poll).get(i);
                if(--edgeCnt[tmp] == 0){
                    treeSet.add(tmp);
                }
            }
        }

        System.out.println(sb);
    }
}
