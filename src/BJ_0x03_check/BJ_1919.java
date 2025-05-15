package BJ_0x03_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int[] firstArr = new int[26];
        int[] secondArr = new int[26];

        for(int i = 0; i < first.length(); i++){
            firstArr[first.charAt(i) - 97] += 1;
        }

        for(int i = 0; i < second.length(); i++){
            secondArr[second.charAt(i) - 97] += 1;
        }

        int sum = 0;
        for(int i = 0; i < 26; i++){
            sum += Math.abs(firstArr[i] - secondArr[i]);
        }

        System.out.println(sum);

    }
}
