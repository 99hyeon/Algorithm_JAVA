package BJ_0x19_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1967 {

    static List<List<Edge>> list;
    static boolean[] visit;
    static int max = 0;

    static class Edge{
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Edge(v, w));
            list.get(v).add(new Edge(u, w));
        }

        visit = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            visit[i] = true;
            dfs(i, 0);
            visit[i] = false;
        }

        System.out.println(max);
    }

    static void dfs(int node, int sum){

        for(int i = 0; i < list.get(node).size(); i++){
            Edge next = list.get(node).get(i);

            if(!visit[next.end]){
                visit[next.end] = true;
                sum += next.weight;
                dfs(next.end, sum);
                visit[next.end] = false;
                sum -= next.weight;
            }
        }

        max = Math.max(max, sum);
    }
}
