package BJ_0x09_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573 {


    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int M;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int tmp = Integer.parseInt(st.nextToken());

                board[i][j] = tmp;
                if(tmp != 0){
                    queue.add(new int[] {i, j});
                }
            }
        }

        int day = 0;
        if(queue.isEmpty()){
            System.out.println(0);
        }else{
            int check = check();

            while(check== 1){
                bfs();
                day++;
                check = check();
            }

            if(check == 0){
                System.out.println(0);
            }else{
                System.out.println(day);
            }
        }
    }

    static void bfs(){

        int[][] tmpBoard = new int[N][M];
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            int count = 0;
            for(int i = 0; i < 4; i++){     // 빙하 얼마나 녹는지 카운트
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                if(board[nextX][nextY] == 0){
                    count++;
                }
            }

            if(board[currentX][currentY] - count <= 0){
                tmpBoard[currentX][currentY] = 0;
            }else{
                tmpBoard[currentX][currentY] = board[currentX][currentY] - count;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                board[i][j] = tmpBoard[i][j];
            }
        }
    }

    static int check(){
        int count = 0;
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] != 0 && !visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        queue.add(new int[] {x, y});

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;

            if(!visited[nextX][nextY] && board[nextX][nextY] != 0){
                dfs(nextX, nextY);
            }
        }
    }
}
