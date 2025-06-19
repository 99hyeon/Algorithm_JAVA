package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16920 {

    static int N;
    static int M;
    static int P;
    static int[] S;
    static char[][] board;
    static Queue<int[]>[] queue;
    static int[] castles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        castles = new int[P + 1];
        queue = new LinkedList[P + 1];

        S = new int[P + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= P; i++){
            S[i] = Integer.parseInt(st.nextToken());
            queue[i] = new LinkedList<>();
        }

        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                char tmpChar = tmp.charAt(j);

                if('1' <= tmpChar && tmpChar <= '9'){
                    queue[tmpChar - '0'].add(new int[] {i, j});
                }
                board[i][j] = tmpChar;
            }
        }

        bfs();
        for(int i = 1; i <= P; i++){
            sb.append(castles[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean checkLoop;
        while(true){
            checkLoop = false;
            for(int i = 1; i <= P; i++){
                for(int s = 0; s < S[i]; s++){
                    int size = queue[i].size();
                    for(int j = 0; j < size; j++){
                        checkLoop = true;
                        int[] poll = queue[i].poll();
                        int currentX = poll[0];
                        int currentY = poll[1];
                        castles[i]++;

                        for(int k = 0; k < 4; k++) {
                            int nextX = currentX + dx[k];
                            int nextY = currentY + dy[k];

                            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                                continue;

                            if(board[nextX][nextY] != '.')
                                continue;

                            board[nextX][nextY] = board[currentX][currentY];
                            queue[i].add(new int[] {nextX, nextY});
                        }
                    }

                    if(queue[i].isEmpty())
                        break;
                }
            }

            if(!checkLoop)
                break;
        }
    }

}
