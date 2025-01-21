package BJ_0x18_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_5567 {

    static List<List<Integer>> list;
    static List<Integer> attendance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        attendance = new ArrayList<>();
        attendance.add(1);

        for(int i = 0; i < list.get(1).size(); i++){
            if(!attendance.contains(list.get(1).get(i))) attendance.add(list.get(1).get(i));
            dfs(list.get(1).get(i), 0);
        }

        System.out.println(attendance.size() - 1);
    }

    static void dfs(int idx, int depth){
        if(depth == 1){
            return;
        }

        for(int i = 0; i < list.get(idx).size(); i++){
            int tmp = list.get(idx).get(i);
            if(!attendance.contains(tmp)){
                attendance.add(tmp);
                dfs(tmp, depth + 1);
            }
        }
    }
}
