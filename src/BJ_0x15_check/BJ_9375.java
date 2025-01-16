package BJ_0x15_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            HashMap<String, Integer> hashMap = new HashMap<>();

            int num = Integer.parseInt(br.readLine());
            for(int j = 0; j < num; j++){
                st = new StringTokenizer(br.readLine());
                String clothes = st.nextToken();
                String kind = st.nextToken();

                if(hashMap.containsKey(kind)){
                    hashMap.put(kind, hashMap.get(kind) + 1);
                }else{
                    hashMap.put(kind, 1);
                }
            }

            int result = 1;
            for (Integer value : hashMap.values()) {
                result *= (value + 1);
            }

            sb.append(result - 1).append("\n");
        }

        System.out.println(sb);
    }
}
