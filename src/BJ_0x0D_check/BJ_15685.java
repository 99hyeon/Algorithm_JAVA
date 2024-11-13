package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_15685 {

    static Queue<Curve> curveQueue;
    static boolean[][] board;

    static class Curve{
        int startX;
        int startY;
        int direction;
        int generation;

        public Curve(int startX, int startY, int direction, int generation) {
            this.startX = startX;
            this.startY = startY;
            this.direction = direction;
            this.generation = generation;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int curveNum = Integer.parseInt(br.readLine());
        board = new boolean[101][101];

        curveQueue = new LinkedList<>();
        for (int i = 0; i < curveNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            curveQueue.add(new Curve(x, y, d, g));
        }

        while(!curveQueue.isEmpty()){
            check(curveQueue.poll());
        }
        System.out.println(checkEdge());
    }

    static void check(Curve curve){
        int generationCnt = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int currentX = curve.startX;
        int currentY = curve.startY;

        List<Integer> makeCurve = new ArrayList<>();
        board[currentY][currentX] = true;

        currentX = currentX + dx[curve.direction];
        currentY = currentY + dy[curve.direction];
        board[currentY][currentX] = true;

        int tmpdir = curve.direction;
        if(curve.direction == 3){
            tmpdir = 0;
        }else{
            tmpdir += 1;
        }
        makeCurve.add(tmpdir);


        while(curve.generation != 0){
            int size = makeCurve.size();
            generationCnt++;

            for(int i = size - 1; i >= 0; i--){
                int direction = makeCurve.get(i);

                currentX += dx[direction];
                currentY += dy[direction];

                board[currentY][currentX] = true;

                if(direction == 3){
                    direction = 0;
                }else{
                    direction += 1;
                }

                makeCurve.add(direction);
            }

            if(generationCnt >= curve.generation)
                break;
        }
    }

    static int checkEdge(){
        int cnt = 0;
        int[] dx = {0, 1, 0, 1};
        int[] dy = {0, 0, 1, 1};

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                boolean check = true;
                for(int k = 0; k < 4; k++){
                    int x = j + dx[k];
                    int y = i + dy[k];

                    if(!board[y][x]){
                        check = false;
                        break;
                    }
                }
                if(check)
                    cnt++;
            }
        }

        return cnt;
    }
}
