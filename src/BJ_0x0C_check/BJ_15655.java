package BJ_0x0C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655 {

    static int N;
    static int M;
    static int[] arr;
    static int[] outArr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        outArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);


    }

    static void dfs(int index, int depth){
        if(depth == M){
            for (int i : outArr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = index; i < N; i++){
            outArr[depth] = arr[i];
            dfs(i+1, depth+1);
        }
    }
}
