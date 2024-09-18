package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012 {

    static int[][] board;
    static int width;
    static int height;
    static boolean[][] visited;
    static int earthworm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int vegetable = Integer.parseInt(st.nextToken());

            board = new int[width][height];
            for(int j = 0; j < vegetable; j++){     //배추 세팅
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[x][y] = 1;
            }

            visited = new boolean[width][height];
            earthworm = 0;
            for(int j = 0; j < width; j++){
                for(int k = 0; k < height; k++){
                    if(board[j][k] == 1 && !visited[j][k]){
                        bfs(j, k);
                        earthworm++;
                    }
                }
            }
            sb.append(earthworm).append("\n");
        }

        System.out.println(sb);

    }

    static void bfs(int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= width || nextY >= height)
                    continue;
                if(board[nextX][nextY] == 0 || visited[nextX][nextY])
                    continue;

                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
    }
}
