package BJ_0x15_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20166 {

    static char[][] board;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = tmp.charAt(j);
            }
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < K; i++){
            String string = br.readLine();

            if(!hashMap.isEmpty() && hashMap.containsKey(string)){
                sb.append(hashMap.get(string)).append("\n");
                continue;
            }

            int cnt = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    cnt += bfs(string, j, k);
                }
            }
            hashMap.put(string, cnt);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(String string, int startX, int startY){
        if(board[startX][startY] != string.charAt(0)){
            return 0;
        }

        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); // x, y, index

        int cnt = 0;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int currentX = poll[0];
            int currentY = poll[1];
            int currentIdx = poll[2];

            if(currentIdx == string.length() - 1){
                cnt++;
                continue;
            }

            for(int i = 0; i < 8; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                int nextIdx = currentIdx + 1;

                if(nextX == -1)
                    nextX = N - 1;
                if(nextX == N)
                    nextX = 0;
                if(nextY == -1)
                    nextY = M - 1;
                if(nextY == M)
                    nextY = 0;

                if(board[nextX][nextY] == string.charAt(nextIdx)){
                    queue.add(new int[]{nextX, nextY, nextIdx});
                }
            }
        }

        return cnt;
    }
}
