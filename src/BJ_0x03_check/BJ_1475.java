package BJ_0x03_check;

import java.util.Scanner;

public class BJ_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String tmpNum = sc.next();
        int[] numArr = new int[tmpNum.length()];

        for(int i = 0; i < tmpNum.length(); i++){
            numArr[i] = tmpNum.charAt(i) - '0';
        }

        int[] setArr = new int[10];
        for(int i = 0; i < setArr.length; i++){
            setArr[i] = 0;
        }

        int set = 0;
        int nineSix = 0;
        for (int i : numArr) {
            if(i == 6 || i == 9){
                setArr[6]++;
                if(setArr[6] > nineSix){
                    nineSix = setArr[6];
                }
            }
            else{
                setArr[i]++;
                if(setArr[i] > set){
                    set = setArr[i];
                }

            }
        }

        int tmpNineSix = 0;
        if(nineSix % 2 == 0){
            tmpNineSix = nineSix / 2;
        }else{
            tmpNineSix = nineSix / 2 + 1;
        }
        if(tmpNineSix > set){
            System.out.println(tmpNineSix);
        }else{
            System.out.println(set);
        }
    }
}

/**
 * 여러번의 시도 끝에 정답
 * 틀렸던 이유
 * 1. int로 입력값을 받아왔을 때 000이 들어오면 0으로 인식
 * (위 내용은 상관없을거 같기도 함. 입력값으로 자연수가 들어온다고 했기 때문. 다른 이유때문에 계속 틀렸던 듯)
 * 2. Math.ceil을 사용하면 1/2는 0으로 인식됨
 * 찾아보니 정수형끼리 나누면 소수점이 사라짐
 * 즉 1/10 = 0.1 => 0으로 출력
 * 1.0/10.0 = 0.1 => 1로 출력
 *
 * 다른 사람들의 코드도 참고해봐야겠다.
 */
