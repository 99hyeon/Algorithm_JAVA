package BJ_0x1B_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_10423 {
    static int[] parent;
    static List<Integer> power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        power = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            power.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Edge> cable = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cable.add(new Edge(u, v, w));
        }
        Collections.sort(cable, ((o1, o2) -> o1.w - o2.w));

        int cost = 0;
        for (Edge edge : cable) {
            int pu = find(edge.u);
            int pv = find(edge.v);

            if(power.contains(pu) && power.contains(pv)){
                continue;
            }else if(pu != pv){
                union(edge.u, edge.v);
                cost += edge.w;
            }
        }

        System.out.println(cost);

    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(power.contains(px)){
            parent[py] = px;
            return;
        }else if(power.contains(py)){
            parent[px] = py;
            return;
        }

        parent[px] = py;
    }

    static class Edge{
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
