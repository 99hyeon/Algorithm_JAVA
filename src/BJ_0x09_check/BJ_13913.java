package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13913 {

    static int N;
    static int K;
    static int MAX = 200001;
    static int[] parent;
    static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[MAX];
        move = new int[MAX];

        sb.append(bfs()).append("\n");
        List<Integer> list = new ArrayList<>();

        int find = K;
        while(find != N){
            list.add(find);
            find = parent[find];
        }
        list.add(N);

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static int bfs(){
        int[] dx = {-1, 1, 2};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});
        parent[N] = N;
        move[N] = -1;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int current = poll[0];
            int count = poll[1];

            for(int i = 0; i < 3; i++){
                int next;

                if(i == 2){
                    next = current * dx[i];
                }else{
                    next = current + dx[i];
                }

                if(next < 0 || next >= MAX)
                    continue;
                if(move[next] != 0 && move[next] <= count + 1)
                    continue;

                parent[next] = current;
                move[next] = count + 1;
                if(next == K){
                    return count + 1;
                }

                queue.add(new int[] {next, count + 1});
            }
        }

        return 0;
    }

}
