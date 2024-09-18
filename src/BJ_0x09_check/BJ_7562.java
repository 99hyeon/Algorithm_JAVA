package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7562 {

    static int[][] board;
    static boolean[][] visit;
    static int size;
    static int[] start;
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            size = Integer.parseInt(br.readLine());
            board = new int[size][size];

            for(int j = 0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                if(j == 0){
                    bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }else{
                    sb.append(board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
                }
            }
        }

        System.out.println(sb);

    }

    static void bfs(int x, int y){
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < 8; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX == x && nextY == y)
                    continue;
                if(nextX < 0 || nextY < 0 || nextX >= size || nextY >= size)
                    continue;

                if(board[nextX][nextY] == 0){
                    board[nextX][nextY] = board[currentX][currentY] + 1;
                    queue.add(new int[] {nextX, nextY});
                }else if(board[nextX][nextY] > board[currentX][currentY] + 1){
                    board[nextX][nextY] = board[currentX][currentY] + 1;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

    }


}
