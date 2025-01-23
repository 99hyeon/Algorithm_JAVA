package BJ_0x18_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1707 {

    static List<List<Integer>> list;
    static int[] divide;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for(int j = 0; j <= V; j++){
                list.add(new ArrayList<>());
            }

            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list.get(start).add(end);
                list.get(end).add(start);
            }

            divide = new int[V + 1];
            boolean check = true;

            for(int j = 1; j <= V; j++){
                if(divide[j] == 0){
                    check = dfs(j, 0);
                    if(!check)
                        break;
                }
            }

            if(check){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);

    }

    static boolean dfs(int current, int priorColor){
        if(priorColor == 0){
            divide[current] = 1;
        }

        for(int i = 0; i < list.get(current).size(); i++){
            if(divide[list.get(current).get(i)] == 0){
                divide[list.get(current).get(i)] = divide[current] == 1 ? 2 : 1;
                if(!dfs(list.get(current).get(i), divide[current])){
                    return false;
                }
            }else if(divide[list.get(current).get(i)] == divide[current]){
                return false;
            }
        }

        return true;
    }
}

/**
 * 다시
 */
