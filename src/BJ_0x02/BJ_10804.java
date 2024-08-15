package BJ_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] card = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            while(first < last){
                int tmp = card[first];
                card[first] = card[last];
                card[last] = tmp;

                first++;
                last--;
            }
        }


        for (int i = 1; i <= 20; i++) {
            System.out.print(card[i] + " ");
        }

    }
}
