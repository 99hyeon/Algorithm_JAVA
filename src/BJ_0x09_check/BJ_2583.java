package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2583 {

    static int[][] board;
    static boolean[][] visited;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        List<Integer> area = new ArrayList<>();
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    area.add(bfs(i, j));
                }
            }
        }

        Collections.sort(area);
        sb.append(area.size()).append("\n");
        for (Integer integer : area) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }

    static void rectangle(int startX, int startY, int endX, int endY){
        for(int i = startY; i < endY; i++){
            for(int j = startX; j < endX; j++){
                visited[i][j] = true;
            }
        }
    }

    static int bfs(int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        int area = 1;
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
                    continue;
                if(visited[nextX][nextY])
                    continue;

                visited[nextX][nextY] = true;
                area += 1;
                queue.add(new int[] {nextX, nextY});
            }
        }

        return area;
    }
}
