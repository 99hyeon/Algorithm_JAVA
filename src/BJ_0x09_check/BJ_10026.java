package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10026 {

    static int n;
    static char[][] board;
    static boolean[][] visit;
    static boolean[][] visitBlind;

    static int area = 0;
    static int areaBlind = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        visit = new boolean[n][n];
        visitBlind = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = tmp.charAt(j);
            }
        }
        br.close();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j]){
                    bfs(i, j, board[i][j], false);
                }
                if(!visitBlind[i][j]){
                    bfs(i, j, board[i][j], true);
                }
            }
        }

        System.out.println(area + " " + areaBlind);
    }

    static void bfs(int x, int y, char color, boolean blindness){
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

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                    continue;

                if(blindness){
                    if(color == 'R' || color == 'G'){
                        if(board[nextX][nextY] != 'B' && !visitBlind[nextX][nextY]){
                            queue.add(new int[] {nextX, nextY});
                            visitBlind[nextX][nextY] = true;
                        }
                    }else{
                        if(board[nextX][nextY] == 'B' && !visitBlind[nextX][nextY]){
                            queue.add(new int[] {nextX, nextY});
                            visitBlind[nextX][nextY] = true;
                        }
                    }
                }else{
                    if(color == 'R' && board[nextX][nextY] == 'R' && !visit[nextX][nextY]){
                        queue.add(new int[] {nextX, nextY});
                        visit[nextX][nextY] = true;
                    }else if(color == 'G' && board[nextX][nextY] == 'G' && !visit[nextX][nextY]){
                        queue.add(new int[] {nextX, nextY});
                        visit[nextX][nextY] = true;
                    }else if(color == 'B' && board[nextX][nextY] == 'B' && !visit[nextX][nextY]){
                        queue.add(new int[] {nextX, nextY});
                        visit[nextX][nextY] = true;
                    }
                }
            }
        }
        if(blindness){
            areaBlind++;
        }else{
            area++;
        }
    }
}

/**
 * 적록색약 : (R G) B
 * 적록색약X : R G B
 */