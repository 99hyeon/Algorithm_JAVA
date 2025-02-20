package BJ_0x1D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11779 {
    static class Edge implements Comparable<Edge> {
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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] trace = new int[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<Edge>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Edge(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        boolean[] visit = new boolean[n + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        while(!queue.isEmpty()){
            Edge poll = queue.poll();

            if(!visit[poll.end]) visit[poll.end] = true;
            else continue;

            for(int i = 0; i < list.get(poll.end).size(); i++){
                Edge next = list.get(poll.end).get(i);

                if(dist[next.end] > dist[poll.end] + next.weight){
                    dist[next.end] = dist[poll.end] + next.weight;
                    trace[next.end] = poll.end;
                    queue.add(new Edge(next.end, dist[next.end]));
                }
            }
        }

        List<Integer> route = new ArrayList<>();
        int idx = end;
        while(trace[idx] != 0){
            route.add(idx);
            idx = trace[idx];
        }
        route.add(start);

        sb.append(dist[end]).append("\n");
        sb.append(route.size()).append("\n");
        for(int i = route.size() - 1; i >= 0; i--){
            sb.append(route.get(i)).append(" ");
        }

        System.out.println(sb);
    }

}
