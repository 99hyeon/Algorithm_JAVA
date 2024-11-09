package BJ_0x03_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[num];
        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int v = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i : array) {
            if(i == v){
                count++;
            }
        }

        System.out.println(count);

    }
}
