//package BJ_0x0D_check;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BJ_13460 {
//
//    static char[][] board;
//    static int[][] redBoard;
//    static int[][] blueBoard;
//
//    static int N;
//    static int M;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        board = new char[N][M];
//        red = new int[N][M];
//        blue = new int[N][M];
//
//
//        int redX, redY, blueX, blueY;
//        for(int i = 0; i < N; i++){
//            String tmp = br.readLine();
//            for(int j = 0; j < M; j++){
//                char tmpChar = tmp.charAt(j);
//
//                if(tmpChar == 'R'){
//                    redX = i;
//                    redY = j;
//                } else if(tmpChar == 'B'){
//                    blueX = i;
//                    blueY = j;
//                }
//                board[i][j] = tmpChar;
//            }
//        }
//
//    }
//
//    static void redMove(int redX, int redY){
//        int[] dx = {-1, 1, 0, 0};
//        int[] dy = {0, 0, -1, 1};
//
//        Queue<int[]> redQueue = new LinkedList<>();
//        redQueue.add(new int[] {redX, redY});
//        while(!redQueue.isEmpty()){
//            int[] poll = redQueue.poll();
//            int currentX = poll[0];
//            int currentY = poll[1];
//
//            for(int i = 0; i < 4; i++){
//                int nextX = currentX + dx[i];
//                int nextY = currentY + dy[i];
//
//                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
//                    continue;
//                if(board[nextX][nextY] == '#' || redBoard[nextX][nextY] != 0)
//                    continue;
//
//
//            }
//
//
//        }
//
//
//    }
//
//    static void moveForward(int currentX, int currentY, int direction){
//
//
//    }
//
//}
