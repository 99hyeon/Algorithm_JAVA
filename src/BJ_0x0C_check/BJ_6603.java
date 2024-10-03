package BJ_0x0C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_6603 {

    static int num;
    static int[] arr;
    static int[] outArr = new int[6];
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            num = Integer.parseInt(st.nextToken());
            if(num == 0){
                break;
            }

            arr = new int[num];
            visit = new boolean[num];
            for(int i = 0; i < num; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int currentIdx, int depth){
        if(depth == 6){
            for (int i : outArr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = currentIdx; i < num; i++){
            if(!visit[i]){
                visit[i] = true;
                outArr[depth] = arr[i];
                dfs(i+1, depth+1);
                visit[i] = false;
            }
        }
    }
}
