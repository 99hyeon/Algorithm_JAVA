package BJ_0x1D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1261 {

    static int[][] board;
    static int[][] cost;
    static int INF = Integer.MAX_VALUE;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        cost = new int[N][M];

        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = tmp.charAt(j) - '0';
                cost[i][j] = INF;
            }
        }

        bfs();
        System.out.println(cost[N - 1][M - 1]);

    }

    static void bfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        cost[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;

                if(cost[nextX][nextY] > cost[currentX][currentY] + board[nextX][nextY]){
                    cost[nextX][nextY] = cost[currentX][currentY] + board[nextX][nextY];
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
