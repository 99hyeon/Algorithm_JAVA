package BJ_0x0B_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1992 {

    static StringBuilder sb = new StringBuilder();
    static int[][] board;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        board = new int[size][size];

        for(int i = 0; i < size; i++){
            String line = br.readLine();
            for(int j = 0; j < size; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        compression(0, 0, size);
        System.out.println(sb);
    }

    static boolean check(int startX, int startY, int size){
        int standard = board[startX][startY];

        for(int i = startX; i < startX + size; i++){
            for(int j = startY; j < startY + size; j++){
                if(board[i][j] != standard){
                    return false;
                }
            }
        }

        if(standard == 0){
            sb.append(0);
        }else{
            sb.append(1);
        }

        return true;
    }

    static void compression(int startX, int startY, int size){
        if(!check(startX, startY, size)){
            sb.append("(");
            int tmpSize = size / 2;

            compression(startX, startY, tmpSize);
            compression(startX, startY + tmpSize, tmpSize);

            compression(startX + tmpSize, startY, tmpSize);
            compression(startX + tmpSize, startY + tmpSize, tmpSize);

            sb.append(")");
        }
    }
}
