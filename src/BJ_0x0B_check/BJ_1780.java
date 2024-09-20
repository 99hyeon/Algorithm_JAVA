package BJ_0x0B_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780 {

    static int[][] board;

    static int minus;
    static int zero;
    static int one;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        board = new int[size][size];
        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, size);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    }

    static boolean check(int startX, int startY, int size){
        int standard = board[startX][startY];

        for(int i = startX; i < startX+size; i++){
            for(int j = startY; j < startY + size; j++){
                if(board[i][j] != standard){
                    return false;
                }
            }
        }

        if(standard == -1){
            minus++;
        }else if(standard == 0){
            zero++;
        }else if(standard == 1){
            one++;
        }

        return true;
    }

    static void cut(int startX, int startY, int size){

        if(!check(startX, startY, size)){
            int tmpSize = size / 3;

            cut(startX, startY, tmpSize);
            cut(startX, startY + tmpSize, tmpSize);
            cut(startX, startY + 2*tmpSize, tmpSize);

            cut(startX + tmpSize, startY, tmpSize);
            cut(startX + tmpSize, startY + tmpSize, tmpSize);
            cut(startX + tmpSize, startY + 2*tmpSize, tmpSize);

            cut(startX + 2*tmpSize, startY, tmpSize);
            cut(startX + 2*tmpSize, startY + tmpSize, tmpSize);
            cut(startX + 2*tmpSize, startY + 2*tmpSize, tmpSize);
        }
    }
}
