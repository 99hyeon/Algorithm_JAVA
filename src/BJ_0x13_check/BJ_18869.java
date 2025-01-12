package BJ_0x13_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] universe = new int[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            Set<Integer> tmp = new HashSet<>();
            for(int j = 0; j < N; j++){
                int tmpNum = Integer.parseInt(st.nextToken());

                universe[i][j] = tmpNum;
                tmp.add(tmpNum);
            }

            List<Integer> clone = new ArrayList<>(tmp);
            Collections.sort(clone);
            for(int j = 0; j < N; j++){
                int tmpNum = universe[i][j];

                universe[i][j] = Collections.binarySearch(clone, tmpNum);
            }
        }

        int cnt = 0;
        for(int i = 0; i < M - 1; i++){
            for(int j = i+1; j < M; j++){
                if(Arrays.equals(universe[i], universe[j])){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

/**
 * 다시
 */
