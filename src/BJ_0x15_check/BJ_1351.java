package BJ_0x15_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1351 {

    static HashMap<Long, Long> hashMap;
    static int P;
    static int Q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        hashMap = new HashMap<>();
        hashMap.put((long)0, (long)1);

        System.out.println(calculate(N));
    }

    static long calculate(long num){
        if(num == 0) return 1;
        if(hashMap.containsKey(num)){
            return  hashMap.get(num);
        }

        long first = (long) Math.floor((double) num /  P);
        long second = (long) Math.floor((double) num /  Q);

        hashMap.put(num, calculate(first) + calculate(second));
        return hashMap.get(num);
    }
}
