package BJ_0x0C_check;


import java.util.Scanner;

public class BJ_15649 {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visit = new boolean[N];

        backtracking(0);
        System.out.println(sb);
    }

    static void backtracking(int depth){
        if(depth == M){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                backtracking(depth+1);
                visit[i] = false;
            }
        }
    }
}
