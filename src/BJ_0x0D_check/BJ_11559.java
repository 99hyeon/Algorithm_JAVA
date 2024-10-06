package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11559 {

    static char[][] board = new char[12][6];
    static boolean[][] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0; i < 12; i++){
            String tmp = br.readLine();
            for(int j = 0; j < 6; j++){
                board[i][j] = tmp.charAt(j);
            }
        }

        boolean check = true;
        int sequence = -1;
        while(check){
            sequence++;
            check = false;

            visit = new boolean[12][6];
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){

                    if(board[i][j] != '.' && !visit[i][j]){
                        boolean tmp = bfs(i, j);

                        if(tmp){
                            check = true;
                        }
                    }
                }
            }
            down();
        }

        System.out.println(sequence);
    }

    static boolean bfs(int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> sendQueue = new LinkedList<>();
        queue.add(new int[] {x, y});
        sendQueue.add(new int[] {x, y});

        int count = 0;
        while(!queue.isEmpty()){
            count += 1;

            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            char current = board[currentX][currentY];
            visit[currentX][currentY] = true;

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6)
                    continue;
                if(visit[nextX][nextY] || board[nextX][nextY] != current)
                    continue;

                queue.add(new int[] {nextX, nextY});
                sendQueue.add(new int[] {nextX, nextY});
            }


        }

        if(count >= 4){
            pop(sendQueue);
            return true;
        }else{
            return false;
        }
    }

    static void pop(Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            board[poll[0]][poll[1]] = '.';
        }
    }

    static void down(){
        boolean check = true;

        while(check){
            check = false;
            for(int i = 0; i < 11; i++){
                for(int j = 0; j < 6; j++){

                    if(board[i][j] != '.' && board[i+1][j] == '.'){
                        board[i+1][j] = board[i][j];
                        board[i][j] = '.';
                        check = true;
                    }
                }
            }
        }
    }
}
