package BJ_0x0C_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16987 {

    static int num;
    static int[][] eggs;
    static boolean[] visit;

    static int maxCount = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        eggs = new int[num][2];
        visit = new boolean[num];

        if(num == 1){
            System.out.println(0);
            System.exit(0);
        }

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                eggs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        breakEgg(0, 0);
        System.out.println(maxCount);
    }

    static void breakEgg(int current, int count){
        if(current == num || count == num-1){   //난 count == num으로 했는데 이거하나만 바꿈
            maxCount = Math.max(maxCount, count);
            return;
        }

        if(eggs[current][0] <= 0){
            breakEgg(current + 1, count);
        }else{
            for(int i = 0; i < num; i++){
                if(eggs[i][0] <= 0 || i == current){
                    continue;
                }
                eggs[current][0] = eggs[current][0] - eggs[i][1];
                eggs[i][0] = eggs[i][0] - eggs[current][1];
                int tmpCnt = 0;
                if(eggs[current][0] <= 0){
                    tmpCnt++;
                }
                if(eggs[i][0] <= 0){
                    tmpCnt++;
                }
                breakEgg(current + 1, count + tmpCnt);
                eggs[current][0] = eggs[current][0] + eggs[i][1];
                eggs[i][0] = eggs[i][0] + eggs[current][1];
            }
        }
    }
}


/**
 * 다시 풀기
 * 주석부분 이해안됨
 * 그리고 제일 오른쪽 계란 관련 기준이 이해못함
 * 제일 오른쪽 계란 들었을 때 2번 과정 수행하고 끝내라는거 같음 그래야 맞음
 * 난 제일 오른쪽 계란 들면 2번과정 수행 안하고 끝내라는건줄..
 */
