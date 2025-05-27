package BJ_0x03_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int studentNum = Integer.parseInt(st.nextToken());
        int maxNum = Integer.parseInt(st.nextToken());
        int roomCnt = 0;

        int[][] gradeSex = new int[6][2];
        for(int i = 0; i < studentNum; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            gradeSex[grade - 1][sex]++;
        }

        for (int[] sex : gradeSex) {
            for (int i : sex) {
                if(i != 0){
                    if(i % maxNum != 0){
                        roomCnt += (i / maxNum) + 1;
                    }else{
                        roomCnt += i / maxNum;
                    }
                }
            }
        }

        System.out.println(roomCnt);
    }
}
