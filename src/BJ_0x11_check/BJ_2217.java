package BJ_0x11_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, list.get(i) * (n - i));
        }

        System.out.println(max);
    }

}
