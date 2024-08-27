package BJ_0x09_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] distance = new int[N][M];
        for(int i = 0; i < N; i++){ // distance배열 -1로 초기화
            for(int j = 0; j < M; j++){
                distance[i][j] = -1;
            }
        }

        int[][] board = new int[N][M];
        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }
        br.close();

        Queue<int[]> queue = new LinkedList<>();

        int[] tmp = new int[2];
        tmp[0] = 0;
        tmp[1] = 0;
        queue.add(tmp);
        distance[0][0] = 1;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int tmpDistance = distance[poll[0]][poll[1]];

            if(poll[0] > 0 && board[poll[0] - 1][poll[1]] == 1 && distance[poll[0] - 1][poll[1]] == -1){
                distance[poll[0] - 1][poll[1]] = tmpDistance+1;

                int[] tmptmp = new int[2];
                tmptmp[0] = poll[0] - 1;
                tmptmp[1] = poll[1];
                queue.add(tmptmp);
            }
            if(poll[1] > 0 && board[poll[0]][poll[1] - 1] == 1 && distance[poll[0]][poll[1] - 1] == -1){
                distance[poll[0]][poll[1] - 1] = tmpDistance+1;

                int[] tmptmp = new int[2];
                tmptmp[0] = poll[0];
                tmptmp[1] = poll[1] - 1;
                queue.add(tmptmp);
            }
            if(poll[0] < N-1 && board[poll[0] + 1][poll[1]] == 1 && distance[poll[0] + 1][poll[1]] == -1){
                distance[poll[0] + 1][poll[1]] = tmpDistance+1;

                int[] tmptmp = new int[2];
                tmptmp[0] = poll[0] + 1;
                tmptmp[1] = poll[1];
                queue.add(tmptmp);
            }
            if(poll[1] < M-1 && board[poll[0]][poll[1] + 1] == 1 && distance[poll[0]][poll[1] + 1] == -1){
                distance[poll[0]][poll[1] + 1] = tmpDistance+1;

                int[] tmptmp = new int[2];
                tmptmp[0] = poll[0];
                tmptmp[1] = poll[1] + 1;
                queue.add(tmptmp);
            }

        }

        System.out.println(distance[N-1][M-1]);

    }
}

/**
 * 바킹독 유투브 BFS 참고함
 *
 * 문제 힌트
 * 1로 표기된 각 칸에 도달하는 거리 저장
 */
