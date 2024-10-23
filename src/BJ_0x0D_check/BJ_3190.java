package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3190 {

    static int[][] board;
    static int N;
    static int time = 0;
    static Queue<String[]> directionQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int appleNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < appleNum; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 1;
        }

        int directionNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < directionNum; i++){
            st = new StringTokenizer(br.readLine());

            directionQueue.add(new String[]{st.nextToken(), st.nextToken()});
        }

        move(1);
        System.out.println(time);
    }

    static void move(int direction){
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[] {0, 0});

        while(true){
            time++;

            int[] peek = snake.peekFirst();
            int nextX = peek[0];
            int nextY = peek[1];
            if(direction == 0){
                nextX--;
            }else if(direction == 1){
                nextY++;
            }else if(direction == 2){
                nextX++;
            }else if(direction == 3){
                nextY--;
            }

            int[] next = {nextX, nextY};
            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                break;

            boolean check = false;
            for (int[] compare : snake) {
                if (Arrays.equals(compare, next)) {
                    check = true;
                    break;
                }
            }
            if(check)
                break;

            snake.addFirst(new int[]{nextX, nextY});
            if(board[nextX][nextY] == 0){
                snake.removeLast();
            }else{
                board[nextX][nextY] = 0;
            }

            String[] directionOrder;
            int directionOrderTime;
            char nextDirection;
            if(!directionQueue.isEmpty()){
                directionOrder = directionQueue.peek();
                directionOrderTime = Integer.parseInt(directionOrder[0]);
                nextDirection = directionOrder[1].charAt(0);

                if(time == directionOrderTime){
                    if(nextDirection == 'L'){
                        if(direction == 0){
                            direction = 3;
                        }else{
                            direction--;
                        }
                    }else{
                        if(direction == 3){
                            direction = 0;
                        }else{
                            direction++;
                        }
                    }
                    directionQueue.remove();
                }
            }
        }

    }
}
