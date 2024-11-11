package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15684 {

    static boolean[][] bridgeBoard;
    static int N;
    static int H;
    static int minAddNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        bridgeBoard = new boolean[H][N-1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bridgeBoard[x-1][y-1] = true;
        }

        if(checkPossible()){
            System.out.println(0);
        }else{
            minAddNum = 1;

            while(minAddNum <= 3){
                if(backtracking(0, 0, 0))
                    break;
                minAddNum++;
            }

            if(minAddNum > 3){
                System.out.println(-1);
            }else{
                System.out.println(minAddNum);
            }
        }

    }

    static boolean backtracking(int depth, int x, int y){
        if(depth == minAddNum){
            if(checkPossible())
                return true;
            return false;
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N - 1; j++){
                if(!bridgeBoard[i][j] && checkFrontBack(i, j)){
                    bridgeBoard[i][j] = true;
                    if(backtracking(depth + 1, x+1, y+1)){
                        return true;
                    }
                    bridgeBoard[i][j] = false;
                }
            }
        }

        return false;
    }

    static boolean checkFrontBack(int x, int y){
        int[] dy = {-1, 1};

        for(int i = 0; i < 2; i++){
            int nextY = y + dy[i];

            if(nextY < 0 || nextY >= N - 1)
                continue;

            if(bridgeBoard[x][nextY])
                return false;
        }
        return true;
    }

    static boolean checkPossible(){
        for(int i = 0; i < N; i++){
            if(!moveDown(i))
                return false;
        }
        return true;
    }

    static boolean moveDown(int startY){
        int tmpY = startY;
        int[] dy = {-1, 0};

        for(int i = 0; i < H; i++){
            for(int j = 0; j < 2; j++){
                int nextY = tmpY + dy[j];

                if(nextY < 0 || nextY >= N - 1)
                    continue;

                if(!bridgeBoard[i][nextY])
                    continue;

                if(j == 0){
                    tmpY = nextY;
                }else{
                    tmpY = nextY + 1;
                }
                break;
            }
        }

        if(startY == tmpY){
            return true;
        }

        return false;
    }
}
