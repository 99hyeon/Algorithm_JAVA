package BJ_0x09_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5427 {

    static char[][] board;
    static int[][] fireBoard;
    static int[][] sgBoard;

    static int w;
    static int h;
    static int minOut = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            fireBoard = new int[h][w];
            sgBoard = new int[h][w];

            int sx = 0;
            int sy = 0;
            for(int j = 0; j < h; j++){
                String tmp = br.readLine();
                for(int k = 0; k < w; k++){
                    char tmpChar = tmp.charAt(k);
                    board[j][k] = tmpChar;

                    if(tmpChar == '@'){
                        sx = j;
                        sy = k;
                    }
                }
            }

            for(int j = 0; j < h; j++){
                for(int k = 0; k < w; k++){
                    if(board[j][k] == '*'){
                        fireBfs(j, k);
                    }
                }
            }

            if(sx == 0 || sx == h-1 || sy == 0 || sy == w-1){
                sb.append(1).append("\n");
            }else{
                bfs(sx, sy);
                if(check()){
                    sb.append(minOut+1).append("\n");
//                    System.out.println(minOut+1);
                }else{
                    sb.append("IMPOSSIBLE").append("\n");
//                    System.out.println("IMPOSSIBLE");
                }
            }
        }

        System.out.println(sb);

    }

    static void fireBfs(int x, int y){
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

                if(nextX < 0 || nextY < 0 || nextX >= h || nextY >= w)
                    continue;
                if(board[nextX][nextY] == '#' || board[nextX][nextY] == '*')
                    continue;

                if(fireBoard[nextX][nextY] == 0){
                    fireBoard[nextX][nextY] = fireBoard[currentX][currentY] + 1;
                    queue.add(new int[] {nextX, nextY});
                }else if(fireBoard[nextX][nextY] > fireBoard[currentX][currentY] + 1){
                    fireBoard[nextX][nextY] = fireBoard[currentX][currentY] + 1;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

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

                if(nextX < 0 || nextY < 0 || nextX >= h || nextY >= w)
                    continue;
                if(board[nextX][nextY] != '.' || sgBoard[nextX][nextY] != 0)
                    continue;

                if(fireBoard[nextX][nextY] == 0){
                    sgBoard[nextX][nextY] = sgBoard[currentX][currentY] + 1;
                    queue.add(new int[] {nextX, nextY});
                }else if(fireBoard[nextX][nextY] > sgBoard[currentX][currentY] + 1){
                    sgBoard[nextX][nextY] = sgBoard[currentX][currentY] + 1;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

    }

    static boolean check(){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < h; i++){
            if((board[i][0] == '.' || board[i][0] == '@') && sgBoard[i][0] != 0){
                min = Math.min(sgBoard[i][0], min);
            }
            if((board[i][w-1] == '.' || board[i][w-1] == '@') && sgBoard[i][w-1] != 0){
                min = Math.min(sgBoard[i][w-1], min);
            }
        }

        for(int i = 0; i < w; i++){
            if((board[0][i] == '.' || board[0][i] == '@') && sgBoard[0][i] != 0){
                min = Math.min(sgBoard[0][i], min);
            }
            if((board[h-1][i] == '.' || board[h-1][i] == '@') && sgBoard[h-1][i] != 0){
                min = Math.min(sgBoard[h-1][i], min);
            }
        }

        if(min == Integer.MAX_VALUE || min == 0){
            return false;
        }else{
            minOut = min;
        }

        return true;
    }
}
