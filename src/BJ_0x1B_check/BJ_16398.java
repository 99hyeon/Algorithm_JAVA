package BJ_0x1B_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16398 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        List<Edge> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = i + 1; j < N; j++) {
                list.add(new Edge(i, j, Integer.parseInt(input[j])));
            }
        }
        Collections.sort(list, ((o1, o2) -> Integer.compare(o1.weight, o2.weight)));

        long cost = 0;
        int cnt = 0;
        for(int i = 0; i < list.size(); i++){
            Edge edge = list.get(i);
            if(find(edge.u) != find(edge.v)){
                union(edge.u, edge.v);
                cost += edge.weight;
                cnt++;
            }

            if(cnt == N){
                break;
            }

        }

        System.out.println(cost);
    }

    static class Edge{
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px > py){
            parent[px] = py;
        }else{
            parent[py] = px;
        }
    }

    static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}

/**
 * 다시
 *
 * find시 경로 압축 왜 되는건지
 * return값을 저렇게 바꿈
 */
