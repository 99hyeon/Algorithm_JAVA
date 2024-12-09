package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int allDate = Integer.parseInt(br.readLine());
        Schedule[] array = new Schedule[allDate + 1];

        array[0] = new Schedule(0, 0, 0);
        for(int i = 1; i <= allDate; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            array[i] = new Schedule(day, money, 0);
        }

        for(int i = 1; i <= allDate; i++){
            int tmpDate = i + array[i].day - 1;

            if(tmpDate <= allDate){
                int maxSum = 0;
                for(int j = 0; j <= i - 1; j++){
                    maxSum = Math.max(maxSum, array[j].sum);
                }
                array[tmpDate].sum = Math.max(array[tmpDate].sum, array[i].money + maxSum);
            }
        }

        int max = Integer.MIN_VALUE;
        for (Schedule schedule : array) {
            max = Math.max(schedule.sum, max);
        }

        System.out.println(max);

    }

    public static class Schedule{
        int day;
        int money;
        int sum;

        public Schedule(int day, int money, int sum) {
            this.day = day;
            this.money = money;
            this.sum = sum;
        }
    }
}
