package BJ_0x18_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1043 {
    static int[] parent;
    static List<Integer> trueList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(st.nextToken());
        trueList = new ArrayList<>();
        if(trueNum == 0){
            System.out.println(M);
            System.exit(0);
        }else{
            for(int i = 0; i < trueNum; i++){
                trueList.add(Integer.parseInt(st.nextToken()));
            }
        }

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        List<List<Integer>> party = new ArrayList<>();
        for(int i = 0; i < M; i++){
            party.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            party.get(i).add(x);
            for(int j = 1; j < num; j++){
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                party.get(i).add(y);
            }
        }

        int cnt = 0;
        for (List<Integer> list : party) {
            boolean check = false;
            for (Integer integer : list) {
                if(trueList.contains(find(integer))){
                    check = true;
                    break;
                }
            }
            if(check){
                cnt++;
            }
        }

        System.out.println(M - cnt);
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(trueList.contains(py)){
            int tmp = py;
            py = px;
            px = tmp;
        }

        parent[py] = px;
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return find(parent[x]);
    }
}
