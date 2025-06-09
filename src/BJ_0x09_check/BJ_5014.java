package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5014 {

    static int F;
    static int G;
    static int U;
    static int D;
    static int[] building;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        building = new int[F + 1];
        Arrays.fill(building, Integer.MAX_VALUE);

        bfs(S);
        if (building[G] == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        }else{
            System.out.println(building[G]);
        }
    }

    static void bfs(int S){
        int[] updown = {U, -D};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        building[S] = 0;
        loop:
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int current = poll[0];
            int move = poll[1];

            for(int i = 0; i < 2; i++){
                int next = current + updown[i];

                if(next < 1 || next > F)
                    continue;

                if(building[next] <= move + 1)
                    continue;

                building[next] = move + 1;
                queue.add(new int[] {next, move + 1});

                if(next == G)
                    break loop;
            }
        }
    }

}
