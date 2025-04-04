package BJ_0x10_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int max = dp[0];
        int maxIdx = 0;
        int[] trace = new int[N];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        trace[i] = j;
                        max = Math.max(max, dp[i]);
                        maxIdx = max == dp[i] ? i : maxIdx;
                    }
                }
            }

            if(dp[i] == 0){
                dp[i] = 1;
                trace[i] = i;
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int idx = maxIdx;
        while(true){

            queue.add(array[idx]);

            if(idx == trace[idx]){
                break;
            }
            idx = trace[idx];
        }

        sb.append(max).append("\n");
        while(!queue.isEmpty()){
            sb.append(queue.poll()).append(" ");
        }

        System.out.println(sb);

    }
}
