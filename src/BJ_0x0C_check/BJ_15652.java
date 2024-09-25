package BJ_0x0C_check;

import java.util.Scanner;

public class BJ_15652 {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        visit = new boolean[N];

        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int prior, int depth){
        if(depth == M){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = prior; i < N; i++){
            arr[depth] = i+1;
            dfs(arr[depth] - 1, depth+1);
        }

    }
}