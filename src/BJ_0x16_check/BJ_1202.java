package BJ_0x16_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1202 {

    static class Jewel{
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Jewel> jewels = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if(o1.weight == o2.weight){
                    return o2.price - o1.price;
                }else{
                    return o1.weight - o2.weight;
                }
            }
        });

        int[] bags = new int[K];
        for(int i = 0; i < K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> prices = new PriorityQueue<>(Collections.reverseOrder());
        int jewelIdx = 0;
        long sum = 0;
        for(int i = 0; i < K; i++){
            while(jewelIdx < N && jewels.get(jewelIdx).weight <= bags[i]){
                prices.add(jewels.get(jewelIdx).price);
                jewelIdx++;
            }

            if(!prices.isEmpty()) sum += prices.poll();
        }

        System.out.println(sum);
    }
}

/**
 * 다시
 */