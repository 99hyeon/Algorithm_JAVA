package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13460 {

    static char[][] board;
    static boolean[][][][] visited;

    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int redX = 0;
        int redY = 0;
        int blueX = 0;
        int blueY = 0;
        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = tmp.charAt(j);

                if(board[i][j] == 'R'){
                    redX = i;
                    redY = j;
                }

                if(board[i][j] == 'B'){
                    blueX = i;
                    blueY = j;
                }
            }
        }

        bfs(redX, redY, blueX, blueY, 0);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }

    public static void bfs(int redX, int redY, int blueX, int blueY, int cnt){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(redX, redY, blueX, blueY, cnt));
        while(!queue.isEmpty()){
            Marble poll = queue.poll();

            int curRx = poll.redX;
            int curRy = poll.redY;
            int curBx = poll.blueX;
            int curBy = poll.blueY;
            int curCnt = poll.cnt;

            if(curCnt == 10){
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nextRx = curRx + dx[i];
                int nextRy = curRy + dy[i];
                int nextBx = curBx + dx[i];
                int nextBy = curBy + dy[i];


                boolean redHole = false;
                boolean blueHole = false;

                if(board[nextRx][nextRy] != '#'){
                    int tmpRx = nextRx;
                    int tmpRy = nextRy;

                    while(board[tmpRx][tmpRy] != '#'){
                        if(board[tmpRx][tmpRy] == 'O'){
                            redHole = true;
                            break;
                        }

                        tmpRx += dx[i];
                        tmpRy += dy[i];
                    }
                    nextRx = tmpRx - dx[i];
                    nextRy = tmpRy - dy[i];
                }else{
                    nextRx = curRx;
                    nextRy = curRy;
                }

                if(board[nextBx][nextBy] != '#'){
                    int tmpBx = nextBx;
                    int tmpBy = nextBy;

                    while(board[tmpBx][tmpBy] != '#'){

                        if(board[tmpBx][tmpBy] == 'O'){
                            blueHole = true;
                            break;
                        }

                        tmpBx += dx[i];
                        tmpBy += dy[i];
                    }
                    nextBx = tmpBx - dx[i];
                    nextBy = tmpBy - dy[i];
                }else{
                    nextBx = curBx;
                    nextBy = curBy;
                }

                if(blueHole){
                    continue;
                }

                if(redHole){
                    min = Math.min(min, curCnt + 1);
                }else{
                    if(nextRx == nextBx && nextRy == nextBy){
                        if(i == 0){
                            if(curRx > curBx){
                                nextRx += 1;
                            }else{
                                nextBx += 1;
                            }
                        }
                        if(i == 1){
                            if(curRx < curBx){
                                nextRx -= 1;
                            }else{
                                nextBx -= 1;
                            }
                        }
                        if(i == 2){
                            if(curRy > curBy){
                                nextRy += 1;
                            }else{
                                nextBy += 1;
                            }
                        }
                        if(i == 3){
                            if(curRy < curBy){
                                nextRy -= 1;
                            }else{
                                nextBy -= 1;
                            }
                        }
                    }

                    if(!visited[nextRx][nextRy][nextBx][nextBy]){
                        visited[nextRx][nextRy][nextBx][nextBy] = true;
                        queue.add(new Marble(nextRx, nextRy, nextBx, nextBy, curCnt + 1));
                    }
                }
            }
        }
    }



    static class Marble{
        int redX;
        int redY;
        int blueX;
        int blueY;
        int cnt;

        public Marble(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }
}

/**
 * 다시 풀기
 */