package BJ_0x1A_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edgeCnt = new int[N + 1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int u = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num - 1; j++){
                if(st.hasMoreTokens()){
                    int v = Integer.parseInt(st.nextToken());
                    list.get(u).add(v);
                    u = v;
                }
                edgeCnt[u]++;
            }
        }

        Queue<Integer> zeroEdge = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(edgeCnt[i] == 0){
                zeroEdge.add(i);
            }
        }
        if(zeroEdge.size() == 0){
            System.out.println(0);
            System.exit(0);
        }


        while(!zeroEdge.isEmpty()){
            int poll = zeroEdge.poll();
            sb.append(poll).append("\n");

            for (int node : list.get(poll)) {
                if(--edgeCnt[node] == 0){
                    zeroEdge.add(node);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(edgeCnt[i] != 0){
                System.out.println(0);
                System.exit(0);
            }
        }

        System.out.println(sb);
    }
}
