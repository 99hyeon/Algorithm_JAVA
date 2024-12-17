package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1915 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        int maxSize = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){

                if(i == 0 || j == 0){
                    maxSize = Math.max(maxSize, board[i][j]);
                } else if(board[i][j] == 1){
                    board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
                    maxSize = Math.max(maxSize, board[i][j]);
                }

            }
        }

        System.out.println(maxSize * maxSize);
    }
}

/**
 * 다시
 */
