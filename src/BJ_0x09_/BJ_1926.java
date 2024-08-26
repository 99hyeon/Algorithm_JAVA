package BJ_0x09_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        //보드판이랑 방문기록 세팅
        int[][] board = new int[xSize][ySize];
        boolean[][] checkVisit = new boolean[xSize][ySize];
        for(int i = 0; i < xSize; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < ySize; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int maxSize = Integer.MIN_VALUE;
        int pictureNum = 0;

        Queue<int[]> tmpPicture = new LinkedList<>();
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                if(board[i][j] == 1 && !checkVisit[i][j]){  //보드판 돌면서 방문안한 그림의 시작점 찾기
                    checkVisit[i][j] = true;
                    pictureNum++;

                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = j;
                    tmpPicture.add(tmp);

                    int tmpSize = 0;
                    while(!tmpPicture.isEmpty()){   //그림 시작점 찾으면 BFS 시작
                        int[] tmpPic = tmpPicture.poll();
                        tmpSize++;

                        if(tmpPic[0] > 0 && board[tmpPic[0] - 1][tmpPic[1]] == 1 && !checkVisit[tmpPic[0] - 1][tmpPic[1]]){
                            checkVisit[tmpPic[0] - 1][tmpPic[1]] = true;

                            int[] tmptmp = new int[2];
                            tmptmp[0] = tmpPic[0] - 1;
                            tmptmp[1] = tmpPic[1];
                            tmpPicture.add(tmptmp);
                        }
                        if(tmpPic[1] > 0 && board[tmpPic[0]][tmpPic[1] - 1] == 1 && !checkVisit[tmpPic[0]][tmpPic[1] - 1]){
                            checkVisit[tmpPic[0]][tmpPic[1] - 1] = true;

                            int[] tmptmp = new int[2];
                            tmptmp[0] = tmpPic[0];
                            tmptmp[1] = tmpPic[1] - 1;
                            tmpPicture.add(tmptmp);
                        }
                        if(tmpPic[0] < xSize-1 && board[tmpPic[0] + 1][tmpPic[1]] == 1 && !checkVisit[tmpPic[0] + 1][tmpPic[1]]){
                            checkVisit[tmpPic[0] + 1][tmpPic[1]] = true;

                            int[] tmptmp = new int[2];
                            tmptmp[0] = tmpPic[0] + 1;
                            tmptmp[1] = tmpPic[1];
                            tmpPicture.add(tmptmp);
                        }
                        if(tmpPic[1] < ySize-1 && board[tmpPic[0]][tmpPic[1] + 1] == 1 && !checkVisit[tmpPic[0]][tmpPic[1] + 1]){
                            checkVisit[tmpPic[0]][tmpPic[1] + 1] = true;

                            int[] tmptmp = new int[2];
                            tmptmp[0] = tmpPic[0];
                            tmptmp[1] = tmpPic[1] + 1;
                            tmpPicture.add(tmptmp);
                        }
                    }

                    maxSize = Math.max(maxSize, tmpSize);
                }
            }
        }

        if (pictureNum == 0) {  //그림이 없을 경우 0 출력을 안해서 계속 틀림...ㅎ
            System.out.println(0);
            System.out.println(0);
        }else{
            System.out.println(pictureNum);
            System.out.println(maxSize);
        }
    }
}
