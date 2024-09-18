package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {

    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;
    static int checkDays = 1;
    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;

                if(tmp == 1){
                    queue.add(new int[] {i, j});
                }
            }
        }

        bfs();

        if(check()){
            System.out.println(-1);
        }else{
            System.out.println(checkDays - 1);
        }
    }

    static void bfs(){
        int[] dx = {-1, 1, 0, 0}; //상하좌우
        int[] dy = {0, 0, -1, 1}; //상하좌우

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];

            for(int i = 0; i < 4; i++){
                int nextX = pollX + dx[i];
                int nextY = pollY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                    continue;
                }
                if(board[nextX][nextY] != 0 || visited[nextX][nextY]){
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                board[nextX][nextY] = board[pollX][pollY] + 1;
                checkDays = Math.max(checkDays, board[nextX][nextY]);
            }
        }
    }

    static boolean check(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 0){
                    return true;
                }
            }
        }

        return false;
    }
}

/**
 * 문제 정리
 * 0:안익은 토마토  1:익은 토마토  -1:빈칸
 *
 * 1. 익은 토마토 첫 위치로부터 뻗어나감
 * 2. BFS끝난 후 안익은 토마토 체크
 * 3. 체크된 토마토 익을 수 있는지 유무 체크
 *
 * 출력 : 최소 일수 or -1(토마토 다 못 익는 경우)
 *
 * 힌트 : 시작점을 큐에 한번에 다 넣기
 */