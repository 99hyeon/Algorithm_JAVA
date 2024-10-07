package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class BJ_14891 {

    static ArrayList<Integer>[] wheel = new ArrayList[4];
    static int sum = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 4; i++){
            wheel[i] = new ArrayList<Integer>();
            String tmp = br.readLine();
            for(int j = 0; j < 8; j++){
                wheel[i].add(tmp.charAt(j) - '0');
            }
        }

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            rotation(order, direction);
        }

        sum();
        System.out.println(sum);
    }

    static void rotation(int order, int direction){ // 1:시계방향  -1:반시계
        boolean[] check = new boolean[4];
        int directionNum = order % 2;

        for(int i = order-1; i > 0; i--){
            if(!Objects.equals(wheel[i-1].get(2), wheel[i].get(6))){
                check[i-1] = true;
                check[i] = true;
            }else{
                if(i == order - 1){
                    check[i] = true;
                }
                break;
            }
        }

        for(int i = order-1; i < 3; i++){
            if(!Objects.equals(wheel[i].get(2), wheel[i + 1].get(6))){
                check[i] = true;
                check[i+1] = true;
            }else{
                if(i == order - 1){
                    check[i] = true;
                }
                break;
            }
        }

        for(int i = 0; i < 4; i++){
            if(check[i]){
                if((i+1) % 2 == directionNum){
                    if(direction == -1){
                        wheel[i].add(wheel[i].remove(0));
                    }else{
                        wheel[i].add(0, wheel[i].remove(7));
                    }
                }else{
                    if(direction == -1){
                        wheel[i].add(0, wheel[i].remove(7));
                    }else{
                        wheel[i].add(wheel[i].remove(0));
                    }
                }
            }
        }
    }

    static void sum(){
        for(int i = 0; i < 4; i++){
            if(wheel[i].get(0) == 1){
                sum += Math.pow(2, i);
            }
        }
    }
}
