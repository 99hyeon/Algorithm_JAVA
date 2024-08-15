package BJ_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int avg = 0;
        int middle = 0;

        int[] array = new int[5];
        for(int i = 0; i < 5; i++){
            array[i] = Integer.parseInt(br.readLine());

            avg += array[i];
        }

        Arrays.sort(array);

        System.out.println(avg/5 + "\n" + array[2]);

    }
}
