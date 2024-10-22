package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503 {

    static int[][] board;
    static int N;
    static int M;
    static int cleanNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(x, y, direction);
        System.out.println(cleanNum);
    }

    static void clean(int x, int y, int direction){

        while(true){

            if(board[x][y] == 0){
                cleanNum++;
                board[x][y] = -1;
            }

            if(checkRoom(x, y)){
                while(true){
                    if(direction == 0){
                        direction = 3;
                    }else{
                        direction--;
                    }

                    int nextX = x;
                    int nextY = y;

                    if(direction == 0){
                        nextX--;
                    }else if(direction == 1){
                        nextY++;
                    }else if(direction == 2){
                        nextX++;
                    }else if(direction == 3){
                        nextY--;
                    }

                    if(board[nextX][nextY] == 0){
                        x = nextX;
                        y = nextY;
                        break;
                    }
                }
            }else{
                if(direction == 0){
                    x++;
                }else if(direction == 1){
                    y--;
                }else if(direction == 2){
                    x--;
                }else if(direction == 3){
                    y++;
                }

                if(x < 0 || y < 0 || x >= N || y >= M)
                    break;

                if(board[x][y] == 1)
                    break;
            }
        }


    }

    static boolean checkRoom(int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy= {0, 0, -1, 1};

        boolean check = false;
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;

            if(board[nextX][nextY] == 0){
                check = true;
            }
        }

        return check;
    }
}
