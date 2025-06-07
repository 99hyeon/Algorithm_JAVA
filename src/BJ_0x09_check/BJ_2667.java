package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_2667 {

    static int N;
    static int[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 1 && !visit[i][j]){
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (Integer integer : list) {
            sb.append(integer).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int startX, int startY){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        visit[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        int cnt = 1;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                    continue;
                if(board[nextX][nextY] == 0 || visit[nextX][nextY])
                    continue;

                visit[nextX][nextY] = true;
                cnt++;
                queue.add(new int[]{nextX, nextY});
            }
        }

        return cnt;
    }
}
