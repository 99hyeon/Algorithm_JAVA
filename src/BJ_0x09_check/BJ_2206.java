package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206 {
    static int N;
    static int M;

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N-1 == 0 && M-1 == 0){
            System.out.println(1);
            System.exit(0);
        }

        board = new int[N][M];
        for(int i = 0; i < N; i++){
            String string = br.readLine();
            for(int j = 0; j < M; j++){
                int tmp = string.charAt(j) - '0';
                board[i][j] = tmp;
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        int[][][] distance = new int[2][N][M];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0});
        distance[0][0][0] = 1;
        while(true){
            int[] current = queue.poll();

            if(current == null){
                return -1;
            }
            int currentWall = current[0];
            int currentX = current[1];
            int currentY = current[2];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                if(currentWall == 0){ //벽 뚫은 적 없는 경우
                    if(board[nextX][nextY] == 0 && distance[0][nextX][nextY] == 0){
                        queue.add(new int[] {0, nextX, nextY});
                        distance[0][nextX][nextY] = distance[0][currentX][currentY] + 1;

                        if(nextX == N-1 && nextY == M-1){
                            return distance[0][nextX][nextY];
                        }
                    }else if(board[nextX][nextY] == 1 && distance[0][nextX][nextY] == 0){
                        queue.add(new int[] {1, nextX, nextY});
                        distance[1][nextX][nextY] = distance[0][currentX][currentY] + 1;

                        if(nextX == N-1 && nextY == M-1){
                            return distance[1][nextX][nextY];
                        }
                    }
                }else{  //벽 뚫은 적 있는 경우
                    if(board[nextX][nextY] == 0 && distance[1][nextX][nextY] == 0){
                        queue.add(new int[] {1, nextX, nextY});
                        distance[1][nextX][nextY] = distance[1][currentX][currentY] + 1;

                        if(nextX == N-1 && nextY == M-1){
                            return distance[1][nextX][nextY];
                        }
                    }
                }
            }

        }
    }
}

/**
 * 이 문제는 이해가 갈듯~ 안갈듯~~
 * 봐도봐도 잘 이해가 안 간단 말이지....
 * 나중에 한 번 더!
 * 풀어야 할 문제 당첨
 */