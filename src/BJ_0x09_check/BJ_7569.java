package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569 {

    static int[][][] board;
    static int m;
    static int n;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(board[i][j][k] == 1){
                        bfs(i, j, k);
                    }
                }
            }
        }

        System.out.println(check());
    }

    static void bfs(int k, int x, int y){
        int[] dk = {-1, 1, 0, 0, 0, 0};
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {k, x, y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentK = current[0];
            int currentX = current[1];
            int currentY = current[2];

            for(int i = 0; i < 6; i++){
                int nextK = currentK + dk[i];
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextK < 0 || nextX < 0 || nextY < 0)
                    continue;
                if(nextK >= h || nextX >= n || nextY >= m)
                    continue;
                if(board[nextK][nextX][nextY] != -1 && board[nextK][nextX][nextY] != 1){
                    if(board[nextK][nextX][nextY] == 0){
                        board[nextK][nextX][nextY] = board[currentK][currentX][currentY] + 1;
                        queue.add(new int[] {nextK, nextX, nextY});
                    }
                    else if(board[nextK][nextX][nextY] > board[currentK][currentX][currentY] + 1){
                        board[nextK][nextX][nextY] = board[currentK][currentX][currentY] + 1;
                        queue.add(new int[] {nextK, nextX, nextY});
                    }

                }
            }
        }
    }

    static int check(){
        int count = Integer.MIN_VALUE;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(board[i][j][k] == 0){
                        return -1;
                    }else{
                        count = Math.max(count, board[i][j][k]);
                    }
                }
            }
        }
        return count - 1;
    }
}
