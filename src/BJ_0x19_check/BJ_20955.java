package BJ_0x19_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_20955 {

    static int[] parent;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        for(int i = 0; i < M; i++){
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(find(u) == find(v)){
                cnt++;
                continue;
            }
            union(u, v);
        }

        for(int i = 1; i <= N; i++){
            if(parent[i] < 0)
                cnt++;
        }

        System.out.println(cnt - 1);

    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(parent[px] > parent[py]){
            parent[py] += parent[px];
            parent[px] = py;
            return;
        }

        parent[px] += parent[py];
        parent[py] = px;
    }

    static int find(int child){
        if(parent[child] < 0){
            return child;
        }

        return find(parent[child]);
    }
}

/**
 * 다시
 */
