package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21609 {

    static int[][] board;
    static boolean[][] visit;
    static int N;
    static int M;
    static PriorityQueue<Node> queue;

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int size;
        int rainbowCount;

        public Node(int x, int y, int size, int rainbowCount) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.rainbowCount = rainbowCount;
        }

        @Override
        public int compareTo(Node o) {
            if(size == o.size){
                if(rainbowCount == o.rainbowCount){
                    if(x == o.x){
                        return o.y - y;
                    }

                    return o.x - x;
                }
                return o.rainbowCount - rainbowCount;
            }

            return o.size - size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int score = 0;
        while(true){
            queue = new PriorityQueue<>();
            visit = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visit[i][j] && board[i][j] >= 1 && board[i][j] <= M){
                        bfs(i, j);
                    }
                }
            }

            if(queue.isEmpty())
                break;

            Node poll = queue.poll();
            score += Math.pow(poll.size, 2);
            remove(poll.x, poll.y);

            down();
            rotate();
            down();
        }

        System.out.println(score);
    }

    private static void bfs(int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> bfsQueue = new LinkedList<>();
        boolean[][] tmpVisit = new boolean[N][N];
        int size = 0;
        int rainbowCnt = 0;

        bfsQueue.add(new int[] {x, y});
        tmpVisit[x][y] = true;

        while(!bfsQueue.isEmpty()){
            int[] poll = bfsQueue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            size += 1;

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                    continue;
                if(visit[nextX][nextY] || tmpVisit[nextX][nextY])
                    continue;

                if(board[nextX][nextY] == 0 || board[nextX][nextY] == board[x][y]){
                    tmpVisit[nextX][nextY] = true;
                    visit[nextX][nextY] = board[nextX][nextY] != 0;
                    rainbowCnt += board[nextX][nextY] == 0 ? 1 : 0;
                    bfsQueue.add(new int[] {nextX, nextY});
                }
            }
        }

        if(size >= 2){
            queue.add(new Node(x, y, size, rainbowCnt));
        }
    }

    private static void remove(int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int boardNum = board[x][y];
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {x, y});
        while(!bfsQueue.isEmpty()){
            int[] poll = bfsQueue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            board[currentX][currentY] = -2;
            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                    continue;

                if(board[nextX][nextY] == 0 || board[nextX][nextY] == boardNum){
                    board[nextX][nextY] = -2;
                    bfsQueue.add(new int[] {nextX, nextY});
                }
            }
        }
    }

    private static void down(){
        for(int i = 0; i < N; i++){
            for(int j = N - 1; j >= 0; j--){
                if(board[j][i] >= 0 && board[j][i] <= M){
                    int nextX = j + 1;
                    int boardNum = board[j][i];
                    board[j][i] = -2;
                    while(true) {
                        if (nextX < N && board[nextX][i] == -2) {
                            board[nextX][i] = -2;
                            nextX += 1;
                        } else {
                            board[nextX - 1][i] = boardNum;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void rotate(){
        int[][] tmp = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tmp[N - 1 - j][i] = board[i][j];
            }
        }

        board = tmp;
    }


}
