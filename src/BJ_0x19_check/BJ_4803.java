package BJ_0x19_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_4803 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int caseNum = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0){
                break;
            }

            parent = new int[n + 1];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                union(x, y);
            }

            HashSet<Integer> hashSet = new HashSet<>();
            for(int i = 1; i <= n; i++){
                int tmp = find(i);
                if(tmp != 0){
                    hashSet.add(tmp);
                }
            }

            int length = hashSet.size();
            if(length == 0){
                sb.append("Case " + caseNum + ": No trees.").append("\n");
            }else if(length == 1){
                sb.append("Case " + caseNum + ": There is one tree.").append("\n");
            }else{
                sb.append("Case " + caseNum + ": A forest of " +length+ " trees.").append("\n");
            }

            caseNum++;
        }

        System.out.println(sb);
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py){
            parent[px] = 0;
            return;
        }

        if(px > py){
            parent[px] = py;
        }else{
            parent[py] = px;
        }
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return find(parent[x]);
    }
}
