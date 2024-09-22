package BJ_0x0B_check;

import java.util.Scanner;

public class BJ_2447 {

    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        board = new char[size][size];

        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                board[i][j] = '*';
            }
        }

        blank(0, 0, size);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void blank(int startX, int startY, int size){

        if(size >= 3){
            int tmpSize = size / 3;

            blank(startX, startY, tmpSize);
            blank(startX, startY + tmpSize, tmpSize);
            blank(startX, startY + 2*tmpSize, tmpSize);

            blank(startX + tmpSize, startY, tmpSize);
            putBlank(startX + tmpSize, startY + tmpSize, tmpSize);
            blank(startX + tmpSize, startY + 2*tmpSize, tmpSize);

            blank(startX + 2*tmpSize, startY, tmpSize);
            blank(startX + 2*tmpSize, startY + tmpSize, tmpSize);
            blank(startX + 2*tmpSize, startY + 2*tmpSize, tmpSize);
        }
    }

    static void putBlank(int startX, int startY, int size){
        for(int i = startX; i < startX + size; i++){
            for(int j = startY; j < startY + size; j++){
                board[i][j] = ' ';
            }
        }
    }
}
