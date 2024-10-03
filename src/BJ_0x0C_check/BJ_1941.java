package BJ_0x0C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1941 {

    static char[][] seat = new char[5][5];

    static boolean[] visitBT = new boolean[25];
    static int[] team = new int[7];

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            String tmp = br.readLine();
            for(int j = 0; j < 5; j++){
                seat[i][j] = tmp.charAt(j);
            }
        }

        backtracking(0, 0, 0);
        System.out.println(count);

    }

    static void backtracking(int num, int depth, int yNum){

        if(yNum >= 4){
            return;
        }

        if(depth == 7){
            bfs();
            return;
        }

        for(int i = num; i < 25; i++){
            int x = i / 5;
            int y = i % 5;

            if(!visitBT[i]){
                visitBT[i] = true;

                team[depth] = i;
                if(seat[x][y] == 'Y'){
                    backtracking(i + 1, depth+1, yNum + 1);
                }else{
                    backtracking(i + 1, depth+1, yNum);
                }
                visitBT[i] = false;
            }
        }
    }

    static void bfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[] visit = new boolean[7];

        Queue<int[]> queue = new LinkedList<>();
        visit[0] = true;
        queue.add(new int[] {team[0]/5, team[0]%5});

        int cnt = 1;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextNum = 5*nextX + nextY;

                if(nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5 || nextNum >= 25)
                    continue;

                for(int j = 0; j < 7; j++){
                    if(!visit[j] && team[j] == nextNum){
                        cnt++;
                        queue.add(new int[] { team[j]/5, team[j]%5 });
                        visit[j] = true;
                        break;
                    }
                }
            }
        }

        if(cnt == 7){
            count++;
        }

    }
}

/**
 * 생각지도 못했음
 * 전혀 다른 방식으로 풀고 있었음
 * 다시 풀어보기
 */