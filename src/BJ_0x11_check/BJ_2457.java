package BJ_0x11_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2457 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int flowerNum = Integer.parseInt(br.readLine());
        int[][] flowers = new int[flowerNum][2];

        StringTokenizer st;
        for(int i = 0; i < flowerNum; i++){
            st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDate = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDate = Integer.parseInt(st.nextToken());
            flowers[i][0] = startMonth * 100 + startDate;
            flowers[i][1] = endMonth * 100 + endDate;
        }

        Arrays.sort(flowers, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int startNum = -1;
        for (int i = 0; i < flowerNum; i++) {
            if(flowers[i][0] <= 301){
                if(startNum == -1){
                    startNum = i;
                } else if(flowers[i][1] > flowers[startNum][1]){
                    startNum = i;
                }
            }
        }

        if(startNum == -1){
            System.out.println(0);
            System.exit(0);
        } else if(flowers[startNum][1] > 1130){
            System.out.println(1);
            System.exit(0);
        }

        int count = 1;
        boolean checkLoop;
        while(true){
            checkLoop = true;

            int tmpStartNum = -1;
            for(int i = startNum + 1; i < flowerNum; i++){
                if(flowers[i][0] <= flowers[startNum][1]){
                    if(tmpStartNum == -1){
                        checkLoop = false;
                        tmpStartNum = i;
                    } else if(flowers[i][1] > flowers[tmpStartNum][1]){
                        checkLoop = false;
                        tmpStartNum = i;
                    }
                }
            }

            if(checkLoop){
                break;
            }

            count++;
            startNum = tmpStartNum;
            if(flowers[startNum][1] > 1130){
                break;
            }
        }

        if(flowers[startNum][1] > 1130){
            System.out.println(count);
        }else if(checkLoop){
            System.out.println(0);
        }else{
            System.out.println(0);
        }
    }

}
