package BJ_0x02_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarf = new int[9];

        int sum = 0;
        for(int i = 0; i < 9; i++){
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }

        Arrays.sort(dwarf);

        int a = 0, b = 0;
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - (dwarf[i] + dwarf[j]) == 100){
                    a = i;
                    b = j;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            if(i != a && i != b){
                System.out.println(dwarf[i]);
            }
        }
    }
}
