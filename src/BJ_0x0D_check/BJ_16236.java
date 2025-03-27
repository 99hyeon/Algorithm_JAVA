package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236 {

    static int[][] board;
    static PriorityQueue<Integer> fishList;
    static int N;
    static int sharkX;
    static int sharkY;
    static int sharkSize;
    static int countSec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        fishList = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp != 0 && tmp != 9){
                    fishList.add(tmp);
                }

                if(tmp == 9){
                    sharkX = i;
                    sharkY = j;
                    tmp = 0;
                }
                board[i][j] = tmp;
            }
        }

        sharkSize = 2;
        bfs();

        System.out.println(countSec);
    }

    static void bfs(){
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
        );
        queue.add(new int[] {sharkX, sharkY, 0});

        int eatCount = 0;
        boolean[][] visited = new boolean[N][N];
        visited[sharkX][sharkY] = true;
        while(!queue.isEmpty() && !fishList.isEmpty()){
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int move = poll[2];

            if(board[currentX][currentY] != 0 && board[currentX][currentY] < sharkSize){
                board[currentX][currentY] = 0;
                eatCount += 1;
                countSec += move;
                queue.clear();
                move = 0;
                visited = new boolean[N][N];
                visited[currentX][currentY] = true;

                fishList.poll();

                if(eatCount == sharkSize){
                    sharkSize += 1;
                    eatCount = 0;
                }
            }

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                    continue;
                if(board[nextX][nextY] > sharkSize || visited[nextX][nextY])
                    continue;

                queue.add(new int[] {nextX, nextY, move + 1});
                visited[nextX][nextY] = true;
            }

            if(fishList.isEmpty() || fishList.peek() >= sharkSize){
                break;
            }
        }
    }
}

/**
 * 다시
 */
