package BJ_0x03_check;

import java.util.Scanner;

public class BJ_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alphabet = new int[26];

        String input = sc.next();
        for(int i = 0; i < input.length(); i++){
            alphabet[input.charAt(i) - 97]++;
        }

        for (int i : alphabet) {
            System.out.print(i + " ");
        }
    }
}
