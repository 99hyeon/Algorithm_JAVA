package BJ_0x15_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String address = st.nextToken();
            String pw = st.nextToken();

            hashMap.put(address, pw);
        }

        for(int i = 0; i < M; i++){
            String pw = hashMap.get(br.readLine());

            sb.append(pw).append("\n");
        }

        System.out.println(sb);
    }
}
