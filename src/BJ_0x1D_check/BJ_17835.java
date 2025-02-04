//package BJ_0x1D_check;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class BJ_17835 {
//
//    static int N;
//    static List<List<Node>> list;
//    static long[] cost;
//    static long INF = Long.MAX_VALUE;
//    static PriorityQueue<Node> queue;
//
//    static class Node implements Comparable<Node>{
//        int end;
//        long cost;
//
//        public Node(int end, long cost) {
//            this.end = end;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return Long.compare(this.cost, o.cost);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        list = new ArrayList<>();
//        for(int i = 0; i <= N; i++){
//            list.add(new ArrayList<>());
//        }
//
//        for(int i = 0; i < M; i++){
//            st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            long w = Long.parseLong(st.nextToken());
//
//            list.get(v).add(new Node(u, w));
//        }
//
//        st = new StringTokenizer(br.readLine());
//        cost = new long[N+1];
//        Arrays.fill(cost, INF);
//        queue = new PriorityQueue<>();
//        for(int i = 0; i < K; i++){
//            int tmp = Integer.parseInt(st.nextToken());
//            cost[tmp] = 0;
//            queue.add(new Node(tmp, 0));
//        }
//        br.close();
//
//        dijkstra();
//
//        int idx = 0;
//        long max = Long.MIN_VALUE;
//        for (int i = 1; i <= N; i++) {
//            if(max < cost[i]){
//                idx = i;
//                max = cost[i];
//            }
//        }
//
//        sb.append(idx).append("\n").append(max);
//        System.out.println(sb);
//    }
//
//    static void dijkstra(){
//        while(!queue.isEmpty()){
//            Node poll = queue.poll();
//
//            if(poll.cost > cost[poll.end])
//                continue;
//
//            for (Node node : list.get(poll.end)) {
//                if(poll.cost != INF && cost[node.end] > poll.cost + node.cost){
//                    cost[node.end] = poll.cost + node.cost;
//                    queue.add(new Node(node.end, (int)cost[node.end]));
//                }
//            }
//        }
//    }
//}
