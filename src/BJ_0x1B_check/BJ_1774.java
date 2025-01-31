package BJ_0x1B_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1774 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        ArrayList<int[]> arrayList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrayList.add(new int[] {x, y});
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(find(u) != find(v)){
                union(u, v);
            }
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i < N - 1; i++){
            int[] start = arrayList.get(i);
            for(int j = i + 1; j < N; j++){
                int[] end = arrayList.get(j);
                long dx = (long) Math.pow(start[0] - end[0], 2);
                long dy = (long) Math.pow(start[1] - end[1], 2);
                double distance = Math.sqrt(dx + dy);

                edges.add(new Edge(i+1, j+1, distance));
            }
        }
        Collections.sort(edges, ((o1, o2) -> Double.compare(o1.distance, o2.distance)));

        double cost = 0;
        for (Edge edge : edges) {
            if(find(edge.sIdx) != find(edge.eIdx)){
                cost += edge.distance;
                union(edge.sIdx, edge.eIdx);
            }
        }

        System.out.printf("%.2f\n", cost);
    }

    static class Edge{
        int sIdx;
        int eIdx;
        double distance;

        public Edge(int sIdx, int eIdx, double distance) {
            this.sIdx = sIdx;
            this.eIdx = eIdx;
            this.distance = distance;
        }
    }

    static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px > py){
            parent[px] = py;
            return;
        }

        parent[py] = px;
    }
}
