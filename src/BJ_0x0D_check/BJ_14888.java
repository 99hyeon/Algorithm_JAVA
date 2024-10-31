package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888 {

    static int[] numArray;
    static int[] operator = new int[4];
    static int[] operatorOrder;

    static int operatorNum = 0;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberNum = Integer.parseInt(br.readLine());
        numArray = new int[numberNum];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numberNum; i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
            if(operator[i] > 0){
                operatorNum += operator[i];
            }
        }
        operatorOrder = new int[operatorNum];

        operatorOrder(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void operatorOrder(int depth){
        if(depth == operatorNum){
            performOperate();
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                operator[i]--;
                operatorOrder[depth] = i;
                operatorOrder(depth + 1);
                operator[i]++;
            }
        }
    }

    static void performOperate(){

        int result = numArray[0];

        for(int i = 0; i < operatorOrder.length; i++){
            if(operatorOrder[i] == 0){
                result = result + numArray[i+1];
            }

            if(operatorOrder[i] == 1){
                result = result - numArray[i+1];
            }

            if(operatorOrder[i] == 2){
                result = result * numArray[i+1];
            }

            if(operatorOrder[i] == 3){
                if(result < 0){
                    result = -1 * (Math.abs(result) / numArray[i+1]);
                }else{
                    result = result / numArray[i+1];
                }
            }
        }

        min = Math.min(min, result);
        max = Math.max(max, result);
    }
}
