package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146 {
    static int size;
    static int[][] board;
    static int[][] bridge;
    static boolean[][] visit;
    static int minBridge = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int islandCnt = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        board = new int[size][size];
        bridge = new int[size][size];
        visit = new boolean[size][size];
        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬별로 번호 매기기
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == 1 && !visit[i][j]){
                    dfs(i, j);
                    islandCnt++;
                }
            }
        }

        visit = new boolean[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != 0){
                    bfs(i, j, board[i][j]);
                }
            }
        }

        System.out.println(minBridge);
    }
    static void bfs(int x, int y, int islandIdx){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            visit[currentX][currentY] = true;

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= size || nextY >= size)
                    continue;
                if(board[nextX][nextY] == islandIdx)
                    continue;

                if(board[nextX][nextY] != 0){
                    minBridge = Math.min(minBridge, bridge[currentX][currentY]);
                } else if(bridge[nextX][nextY] == 0 || bridge[nextX][nextY] > bridge[currentX][currentY] + 1){
                    bridge[nextX][nextY] = bridge[currentX][currentY] + 1;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }
    }


    //섬별로 번호 매기기 위한 dfs
    static void dfs(int x, int y){
        visit[x][y] = true;
        board[x][y] = islandCnt;

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= size || nextY >= size)
                continue;
            if(visit[nextX][nextY])
                continue;
            if(board[nextX][nextY] == 0)
                continue;

            dfs(nextX, nextY);
        }
    }
}
