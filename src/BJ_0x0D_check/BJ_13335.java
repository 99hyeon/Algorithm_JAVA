package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13335 {

    static int w;
    static int L;
    static Queue<Integer> waitingTruck = new LinkedList<>();
    static Queue<int[]> onBridge = new LinkedList<>();
    static int time = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            waitingTruck.add(Integer.parseInt(st.nextToken()));
        }

        goThroughBridge();
        System.out.println(time + 1);
    }

    static void goThroughBridge(){
        int weightSum = 0;

        while(true){
            if(waitingTruck.isEmpty() && onBridge.isEmpty()){
                break;
            }
            time++;

            if(weightSum <= L && onBridge.size() < w){
                if(!waitingTruck.isEmpty() && weightSum + waitingTruck.peek() <= L){
                    weightSum += waitingTruck.peek();
                    onBridge.add(new int[] {waitingTruck.poll(), 1});
                }
            }

            int size = onBridge.size();
            while(size > 0){
                int[] poll = onBridge.poll();
                int weight = poll[0];
                int time = poll[1];

                if(time == w){
                    weightSum -= weight;
                }else{
                    onBridge.add(new int[]{weight, time+1});
                }
                size--;
            }
        }

    }

}
