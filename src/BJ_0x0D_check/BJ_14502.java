package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502 {

    static int N;
    static int M;
    static int[][] board;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        wallDfs(0, 0, 0);

        if (max == Integer.MIN_VALUE) {
            System.out.println(0);
        }else
            System.out.println(max);
    }

    static void wallDfs(int x, int y, int depth){
        if(depth == 3){
            virusBfs();
            return;
        }

        for(int i = x; i < N; i++){
            for(int j = y; j < M; j++){
                if(board[i][j] == 0){
                    board[i][j] = 1;
                    wallDfs(x, y, depth + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    static void virusBfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> virus = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 2){
                    virus.add(new int[] {i, j});
                }
            }
        }

        int[][] copyBoard = new int[N][M];
        for(int i = 0; i < N; i++){
            copyBoard[i] = board[i].clone();
        }

        while(!virus.isEmpty()){
            int[] poll = virus.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;
                if(copyBoard[nextX][nextY] != 0)
                    continue;

                copyBoard[nextX][nextY] = 2;
                virus.add(new int[] {nextX, nextY});
            }
        }

        checkSafetyzone(copyBoard);
    }

    static void checkSafetyzone(int[][] board){
        int check = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 0){
                    check++;
                }
            }
        }

        max = Math.max(check, max);
    }
}
