package BJ_0x12_check;

import java.util.Scanner;

public class BJ_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int cnt = 0;
        for(int i = 5; i <= num; i++){
            if(i % 5 == 0){
                int tmp = i;
                while(true){
                    if(tmp % 5 == 0){
                        cnt++;
                    }else{
                        break;
                    }

                    tmp = tmp / 5;
                }
            }
        }

        System.out.println(cnt);
    }
}
