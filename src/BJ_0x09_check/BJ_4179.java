package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179 {
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> queueFire = new LinkedList<>();
    static Queue<int[]> queueOut = new LinkedList<>();
    static int[][] minute;
    static int[][] minuteJ;
    static char[][] board;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        minute = new int[N][M];
        minuteJ = new int[N][M];
        for(int i = 0; i < N; i++){
            String string = br.readLine();
            for(int j = 0; j < M; j++) {
                char tmp = string.charAt(j);
                if(tmp == 'J'){
                    queue.add(new int[] {i, j});
                }
                if(tmp == 'F'){
                    minute[i][j] = 1;
                    minuteJ[i][j] = -1;
                    queueFire.add(new int[] {i, j});
                }
                if((i == 0 || i == N - 1) && tmp == '.'){
                    queueOut.add(new int[] {i, j});
                }
                if((j == 0 || j == M - 1) && tmp == '.'){
                    queueOut.add(new int[] {i, j});
                }
                board[i][j] = tmp;
            }
        }
        br.close();

        int[] checkFirst = queue.peek();
        if(checkFirst[0] == 0 || checkFirst[0] == N-1 || checkFirst[1] == 0 || checkFirst[1] == M-1){
            System.out.println(1);
        }else if(queueOut.isEmpty()){
            System.out.println("IMPOSSIBLE");
        }else{
            bfs();
            bfsJ();

            int tmp = check();
            if(tmp == Integer.MAX_VALUE){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(tmp + 1);
            }
        }

    }

    static void bfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queueFire.isEmpty()){
            int[] current = queueFire.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if(board[nextX][nextY] == '#')
                    continue;

                if(minute[nextX][nextY] == 0){
                    minute[nextX][nextY] = minute[currentX][currentY] + 1;
                    queueFire.add(new int[] {nextX, nextY});
                }
            }

        }
    }

    static void bfsJ(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if (board[nextX][nextY] == '#')
                    continue;

                if(minuteJ[nextX][nextY] == 0){
                    if(minute[nextX][nextY] == 0 || minuteJ[currentX][currentY] + 1 < minute[nextX][nextY] - 1){
                        queue.add(new int[]{nextX, nextY});
                        minuteJ[nextX][nextY] = minuteJ[currentX][currentY] + 1;
                    }
                }
            }
        }
    }

    static int check(){

        int min = Integer.MAX_VALUE;
        while(!queueOut.isEmpty()){
            int[] tmp = queueOut.poll();

            if(minuteJ[tmp[0]][tmp[1]] != 0){
                min = Math.min(minuteJ[tmp[0]][tmp[1]], min);
            }
        }

        return min;
    }

}

/**
 * 지훈이의 위치가 보드의 가장자리면 탈출성공
 *
 * ++ 다른사람 코드 참고해보기
 */