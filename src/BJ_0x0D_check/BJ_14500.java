package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500 {

    static int[][] board;
    static boolean[][] visit;
    static int N;
    static int M;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visit[i][j] = true;
                dfs(i, j, board[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int sum, int count){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visit[x][y] = true;
        if(count == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;
            if(visit[nextX][nextY])
                continue;

            if(count == 2){
                visit[nextX][nextY] = true;
                dfs(x, y, sum + board[nextX][nextY], count + 1);
                visit[nextX][nextY] = false;
            }


            visit[nextX][nextY] = true;
            dfs(nextX, nextY, sum + board[nextX][nextY], count + 1);
            visit[nextX][nextY] = false;
        }
    }
}


/**
 *
 * 다시 풀어보기
 */
