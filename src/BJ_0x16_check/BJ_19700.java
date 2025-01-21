package BJ_0x16_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_19700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            list.add(new int[]{height, k});
        }

        Collections.sort(list, (o1, o2) -> o2[0] - o1[0]);

        int[] teamNum = new int[N + 1];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] student : list) {
            int ki = student[1];
            Integer boundary = treeSet.lower(ki);

            if(boundary == null){
                treeSet.add(1);
                teamNum[1]++;
            }else{
                teamNum[boundary] -= 1;

                if(teamNum[boundary] == 0){
                    treeSet.remove(boundary);
                }
                teamNum[boundary + 1] += 1;
                treeSet.add(boundary + 1);
            }
        }

        int result = 0;
        for (int i : teamNum) {
            result += i;
        }
        System.out.println(result);
    }
}

/**
 * 다시
 * 다른 방법도 1개 있대
 */
