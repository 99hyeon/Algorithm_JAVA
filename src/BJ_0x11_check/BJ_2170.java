package BJ_0x11_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new int[]{x, y});
        }

        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        int result = 0;
        int x = list.get(0)[0];
        int y = list.get(0)[1];
        for(int i = 1; i < num; i++){
            int tmpX = list.get(i)[0];
            int tmpY = list.get(i)[1];

            if(tmpX > y){
                result += (y - x);

                x = tmpX;
                y = tmpY;
            }else if(tmpY > y){
                y = tmpY;
            }
        }
        result += (y - x);

        System.out.println(result);
    }
}
