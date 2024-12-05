package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = array[0];
        for(int i = 1; i < size; i++){
            array[i] = Math.max(array[i], array[i] + array[i - 1]);
            max = Math.max(max, array[i]);
        }

        System.out.println(max);
    }
}
