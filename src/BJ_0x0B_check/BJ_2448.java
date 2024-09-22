package BJ_0x0B_check;

import java.util.Scanner;

public class BJ_2448 {

    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        board = new char[size][2*size-1];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < 2*size - 1; j++){
                board[i][j] = ' ';
            }
        }

        star(0, size - 1, size);


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < 2*size - 1; j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void star(int topX, int topY, int size){

        if(size == 3){
            putStar(topX, topY);
        }else{
            int tmpSize = size/2;

            star(topX, topY, tmpSize);
            star(topX + tmpSize, topY - tmpSize, tmpSize);
            star(topX + tmpSize, topY + tmpSize, tmpSize);
        }
    }

    static void putStar(int topX, int topY){

        board[topX][topY] = '*';

        board[topX+1][topY - 1] = '*';
        board[topX+1][topY + 1] = '*';

        for(int i = 0; i < 5; i++){
            board[topX+2][topY - 2 + i]= '*';
        }
    }
}
