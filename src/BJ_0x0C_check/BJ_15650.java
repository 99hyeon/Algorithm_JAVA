package BJ_0x0C_check;

import java.util.Scanner;

public class BJ_15650 {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        arr[0] = 0;
        visit = new boolean[N];

        sequence(0);
        System.out.println(sb);
    }

    static void sequence(int depth){

        if(depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");

            return;
        }

        int tmp;
        if(depth == 0){
            tmp = 0;
        }else{
            tmp = depth - 1;
        }
        for(int i = arr[tmp]; i < N; i++){
            if(!visit[i]){
                visit[i] = true;

                arr[depth] = i+1;
                sequence(depth+1);
                visit[i] = false;
            }
        }
    }


}

/**
 * 몰라.
 * 나중에 다시 풀어.
 *
 * 참고
 * https://st-lab.tistory.com/114#%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 *
 */