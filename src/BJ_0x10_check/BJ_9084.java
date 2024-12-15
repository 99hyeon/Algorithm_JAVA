package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9084 {

    static int[] moneySum;
    static int[] moneyArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            int typeNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            moneyArr = new int[typeNum];
            for(int j = 0; j < typeNum; j++){
                moneyArr[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            moneySum = new int[M + 1];

            int result = check();
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

    static int check(){
        for(int i = 0; i < moneyArr.length; i++){
            int tmpType = moneyArr[i];
            for(int j = 1; j < moneySum.length; j++){
                if(j - tmpType == 0){
                    moneySum[j] = moneySum[j] + 1;
                }else if(j - tmpType > 0){
                    moneySum[j] = moneySum[j] + moneySum[j - tmpType];
                }
            }
        }

        return moneySum[moneySum.length - 1];
    }
}

/**
 * 다시
 */
