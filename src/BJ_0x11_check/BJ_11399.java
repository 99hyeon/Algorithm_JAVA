package BJ_0x11_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[num];
        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int sum = 0;
        int waiting = 0;
        for (int i : array) {
            sum += (waiting + i);
            waiting += i;
        }

        System.out.println(sum);
    }
}
