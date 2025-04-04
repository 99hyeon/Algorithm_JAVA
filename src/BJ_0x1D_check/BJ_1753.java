package BJ_0x1D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753 {

    private static int INF = Integer.MAX_VALUE;

    private static class Edge implements Comparable<Edge> {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<List<Edge>> list = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Edge(end, weight));
        }

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(K, 0));
        int[] cost = new int[V + 1];
        Arrays.fill(cost, INF);
        cost[K] = 0;

        boolean[] visit = new boolean[V+1];
        visit[K] = true;
        while(!priorityQueue.isEmpty()){
            Edge poll = priorityQueue.poll();

            visit[poll.end] = true;

            for (Edge edge : list.get(poll.end)) {
                if(!visit[edge.end]){
                    if(cost[edge.end] > poll.weight + edge.weight){
                        cost[edge.end] = poll.weight + edge.weight;
                        priorityQueue.add(new Edge(edge.end, cost[edge.end]));
                    }
                }
            }
        }

        for(int i = 1; i <= V; i++){
            if(cost[i] == INF){
                sb.append("INF\n");
            }else{
                sb.append(cost[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
