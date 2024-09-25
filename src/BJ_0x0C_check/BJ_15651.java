package BJ_0x0C_check;

import java.io.IOException;
import java.util.Scanner;

public class BJ_15651 {

    static int N;
    static int M;

    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            arr[depth] = i+1;
            dfs(depth + 1);
        }
    }
}
