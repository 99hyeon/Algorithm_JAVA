package BJ_0x1B_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_13418 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        setParent();

        List<Edge> list = new ArrayList<>();
        for(int i = 0; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Edge(u, v, w));
        }
        Collections.sort(list, (o1, o2) -> o1.w - o2.w);

        int maxCnt = 0;
        for (Edge edge : list) {
            if(find(edge.u) != find(edge.v)){
                union(edge.u, edge.v);

                if(edge.w == 0){
                    maxCnt++;
                }
            }
        }

        int minCnt = 0;
        setParent();
        for(int i = list.size() - 1; i >= 0; i--){
            Edge edge = list.get(i);
            if(find(edge.u) != find(edge.v)){
                union(edge.u, edge.v);

                if(edge.w == 0){
                    minCnt++;
                }
            }
        }

        System.out.println(maxCnt * maxCnt - minCnt * minCnt);

    }

    static void setParent(){
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
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

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
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
