package BJ_0x1B_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1368 {

    static int[] parent;
    static boolean[] visit;


    static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visit = new boolean[N + 1];

        List<Node> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new Node(0, i + 1, Integer.parseInt(br.readLine())));
            parent[i+1] = i+1;
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(j > i){
                    list.add(new Node(i + 1, j + 1, tmp));
                }
            }
        }
        Collections.sort(list);

        int costSum = 0;

        for (Node node : list) {
            if(find(node.start) != find(node.end)){
                visit[node.start] = true;
                visit[node.end] = true;
                union(node.start, node.end);
                costSum += node.cost;
            }

            if(checkVisit()){
                break;
            }
        }

        System.out.println(costSum);
    }

    static boolean checkVisit(){
        for (int i : parent) {
            if(i != 0){
                return false;
            }
        }

        return true;
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px < py){
            parent[py] = px;
        }else{
            parent[px] = py;
        }
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
