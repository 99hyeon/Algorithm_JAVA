package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16933 {
    static int N;
    static int M;
    static int K;
    static int[][] board;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        if(N == 1 && M == 1){
            System.out.println(1);
            System.exit(0);
        }

        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        int result = bfs();
        if(result == 0){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }

    static int bfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        visited = new boolean[N][M][K + 1];
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0][0] = true;
        queue.add(new int[]{0, 0, 0, 1, 1});    //day : 1 , night : 0
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int breakNum = poll[2];
            int cnt = poll[3];
            int dayAndNight = poll[4];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;

                if(nextX == N - 1 && nextY == M - 1)
                    return cnt + 1;

                if(board[nextX][nextY] == 0){
                    if(visited[nextX][nextY][breakNum])
                        continue;

                    visited[nextX][nextY][breakNum] = true;
                    queue.add(new int[]{nextX, nextY, breakNum, cnt + 1, dayAndNight == 1 ? 0 : 1});
                }else{
                    if(breakNum >= K || visited[nextX][nextY][breakNum + 1])
                        continue;

                    if(dayAndNight == 0){
                        visited[currentX][currentY][breakNum] = true;
                        queue.add(new int[]{currentX, currentY, breakNum, cnt + 1, 1});
                        continue;
                    }

                    visited[nextX][nextY][breakNum + 1] = true;
                    queue.add(new int[]{nextX, nextY, breakNum + 1, cnt + 1, dayAndNight == 1 ? 0 : 1});
                }
            }
        }

        return 0;
    }

}
