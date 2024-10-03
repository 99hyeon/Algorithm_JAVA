package BJ_0x0C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16987 {

    static int num;
    static int[][] eggs;
    static boolean[] visit;

    static int maxCount = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        eggs = new int[num][2];
        visit = new boolean[num];

        if(num == 1){
            System.out.println(0);
            System.exit(0);
        }

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                eggs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        breakEgg(0);
        System.out.println(checkEgg());
    }

    static void breakEgg(int depth){
        if(depth == num){
            maxCount = Math.max(maxCount, checkEgg());
        }

        for(int i = 0; i < num; i++){
            if(!visit[i]){

            }
        }
    }

    static int checkEgg(){
        int count = 0;
        for(int i = 0; i < num; i++){
            if(eggs[i][0] <= 0){
                count++;
            }
        }

        return count;
    }
}


/**
 * 다시 풀기
 */
