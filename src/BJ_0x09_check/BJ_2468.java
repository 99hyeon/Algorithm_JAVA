package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468 {

    static int[][] board;
    static boolean[][] visit;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int maxHeight = 2;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, tmp);
                board[i][j] = tmp;
            }
        }

        int max = 1;
        for(int i = 1; i < maxHeight; i++){
            visit = new boolean[N][N];
            int cnt = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(!visit[j][k] && board[j][k] > i){
                        cnt++;
                        dfs(j, k, i);
                    }
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
    static void dfs(int x, int y, int height){
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                continue;
            if(visit[nextX][nextY] || board[nextX][nextY] <= height)
                continue;

            dfs(nextX, nextY, height);
        }
    }
}
