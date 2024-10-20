package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14499 {

    static int N;
    static int M;
    static int[][] board;
    static int[] dice = new int[7];
    static Queue<Integer> orderQueue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int orderNum = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < orderNum; i++){
            orderQueue.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        for(int i = 0; i < 7; i++){
            dice[i] = 0;
        }

        moveDice(x, y);
        System.out.println(sb);
    }

    static void moveDice(int x, int y){

        while(!orderQueue.isEmpty()){
            int order = orderQueue.poll();

            if(order == 1){
                if(y+1 >= M)
                    continue;

                y++;
                changeDice(1);
            }else if(order == 2){
                if(y-1 < 0)
                    continue;

                y--;
                changeDice(2);
            }else if(order == 3){
                if(x-1 < 0)
                    continue;

                x--;
                changeDice(3);
            }else if(order == 4){
                if(x+1 >= N)
                    continue;

                x++;
                changeDice(4);
            }

            if(board[x][y] == 0){
                board[x][y] = dice[6];
            }else {
                dice[6] = board[x][y];
                board[x][y] = 0;
            }
            sb.append(dice[1]).append("\n");
        }
    }

    static void changeDice(int order){
        int tmp = dice[1];

        switch (order) {
            case 1 :
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;
            case 2 :
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3 :
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 4 :
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }
    }
}

/**
 * 주사위 원리 다시 생각해보기
 */