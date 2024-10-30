package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16985 {

    static int[][][] board = new int[5][5][5];
    static int[][][] copyBoard;
    static int[] order = new int[5];

    static int[] direction = new int[5];

    static int min = Integer.MAX_VALUE;

    static boolean[] check = new boolean[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 5; k++){
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        stackOrder(0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else
            System.out.println(min);
    }

    static void stackOrder(int stackNum){
        if(stackNum == 5){
            // 회전 방향
            copyBoard = new int[5][5][5];
//            for(int i = 0; i < 5; i++){
//                rotation(0);
//            }
            rotation(0);
            return;
        }

        for(int i = 0; i < 5; i++){
            if(!check[i]){
                check[i] = true;
                order[stackNum] = i;
                stackOrder(stackNum + 1);
                check[i] = false;
            }
        }
    }

    static void rotation(int depth){
        if(min == 12)
            return;

        if(depth == 5){
            for(int i = 0; i < 5; i++){
                int dir = direction[i];
                int boardOrder = order[i];

                for(int x = 0; x < 5; x++){
                    for(int y = 0; y < 5; y++){

                        if(dir == 0){
                            copyBoard[i][x][y] = board[boardOrder][x][y];
                        }
                        if(dir == 1){
                            copyBoard[i][x][y] = board[boardOrder][4-y][x];
                        }
                        if(dir == 2){
                            copyBoard[i][x][y] = board[boardOrder][4-x][4-y];
                        }
                        if(dir == 3){
                            copyBoard[i][x][y] = board[boardOrder][y][4-x];
                        }
                    }
                }

                if(copyBoard[0][0][0] == 1 && copyBoard[4][4][4] == 1){
                    bfs();
                }

            }
            return;
        }

        for(int i = 0; i < 4; i++){
            direction[depth] = i;
            rotation(depth + 1);
        }
    }

    static void bfs(){
        int[][][] checkDistance = new int[5][5][5];

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentZ = poll[2];

            if(currentX == 4 && currentY == 4 && currentZ == 4)
                break;

            for(int i = 0; i < 6; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                int nextZ = currentZ + dz[i];

                if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5 || nextZ < 0 || nextZ >= 5)
                    continue;
                if(copyBoard[nextX][nextY][nextZ] != 1)
                    continue;

                if(checkDistance[nextX][nextY][nextZ] == 0 || checkDistance[nextX][nextY][nextZ] > checkDistance[currentX][currentY][currentZ] + 1){
                    checkDistance[nextX][nextY][nextZ] = checkDistance[currentX][currentY][currentZ] + 1;
                    queue.add(new int[]{nextX, nextY, nextZ});
                }
            }
        }

        if(checkDistance[4][4][4] != 0){
            min = Math.min(min, checkDistance[4][4][4]);
        }
    }
}

//다시 풀기