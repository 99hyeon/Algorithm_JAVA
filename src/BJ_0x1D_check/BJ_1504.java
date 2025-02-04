package BJ_0x1D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1504 {
    static List<List<Node>> list;
    static boolean[] check;
    static int[] dist;
    static int N;
    static int INF = 200000000;

    static class Node implements Comparable<Node> {
        int idx;
        int w;

        public Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        check = new boolean[N + 1];
        dist = new int[N + 1];

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
            list.get(v).add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int first = 0;
        //1 -> v1 -> v2 -> N
        first += dijkstra(1, v1);
        first += dijkstra(v1, v2);
        first += dijkstra(v2, N);

        //1 -> v2 -> v1 -> N
        int second = 0;
        second += dijkstra(1, v2);
        second += dijkstra(v2, v1);
        second += dijkstra(v1, N);

        int min = (first >= INF && second >= INF) ? -1 : Math.min(first, second);

        System.out.println(min);
    }

    static int dijkstra(int start, int end){
        Arrays.fill(check, false);
        Arrays.fill(dist, INF);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node poll = queue.poll();

            if(check[poll.idx])
                continue;

            check[poll.idx] = true;
            for (Node node : list.get(poll.idx)) {
                if(dist[node.idx] > poll.w + node.w){
                    dist[node.idx] = poll.w + node.w;
                    queue.add(new Node(node.idx, dist[node.idx]));
                }
            }
        }

        return dist[end];
    }
}

/**
 * 다시풀어보기
 */
