package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14890 {

    static int N;
    static int L;
    static int[][] board;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            if(check(i, true))
                count++;
            if(check(i, false))
                count++;
        }

        System.out.println(count);

    }

    static boolean check(int idx, boolean isWidth){
        int[] tmpBoardX = new int[N];
        if(isWidth){
            tmpBoardX = board[idx].clone();
        }else{
            for(int i = 0; i < N; i++){
                tmpBoardX[i] = board[i][idx];
            }
        }

        boolean[] checkBirdge = new boolean[N];
        int bridgeCnt = 0;

        int currentIdx = 0;
        while(currentIdx < N-1){
            int diff = tmpBoardX[currentIdx] - tmpBoardX[currentIdx + 1];

            if(diff == -1){
                if(checkBirdge[currentIdx])
                    return false;

                checkBirdge[currentIdx] = true;
                bridgeCnt++;

                int tmpIdx = currentIdx;
                while(bridgeCnt < L){
                    tmpIdx -= 1;
                    if(tmpIdx < 0)
                        return false;

                    if(tmpBoardX[currentIdx] == tmpBoardX[tmpIdx]){
                        if(!checkBirdge[tmpIdx]){
                            checkBirdge[tmpIdx] = true;
                            bridgeCnt++;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                bridgeCnt = 0;
                currentIdx++;
            }

            if(diff == 1){
                int tmpIdx = currentIdx;
                while(bridgeCnt < L){
                    tmpIdx += 1;
                    if(tmpIdx >= N)
                        return false;

                    if(tmpBoardX[currentIdx+1] == tmpBoardX[tmpIdx]){
                        if(!checkBirdge[tmpIdx]){
                            checkBirdge[tmpIdx] = true;
                            bridgeCnt++;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                bridgeCnt = 0;
                currentIdx = tmpIdx;
            }

            if(diff == 0){
                currentIdx++;
            }

            if(diff >= 2 || diff <= -2)
                return false;

        }

        return true;
    }
}

/**
 * 다시 풀기 지금은 막코딩인듯..?
 */