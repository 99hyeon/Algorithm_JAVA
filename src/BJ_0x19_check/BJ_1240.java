package BJ_0x19_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1240 {

    static boolean[] visit;
    static int[] distance;
    static List<List<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new int[]{v, w});
            list.get(v).add(new int[]{u, w});
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int find = Integer.parseInt(st.nextToken());

            visit = new boolean[N + 1];
            distance = new int[N + 1];

            dfs(start, find);
            sb.append(distance[find]).append("\n");
        }

        System.out.println(sb);
    }

    static boolean dfs(int start, int find){
        if(start == find){
            return true;
        }

        visit[start] = true;
        for (int[] node : list.get(start)) {
            if(visit[node[0]]) continue;

            distance[node[0]] += (node[1] + distance[start]);
            boolean check = dfs(node[0], find);
            if(check){
                return true;
            }
        }

        return false;
    }
}
