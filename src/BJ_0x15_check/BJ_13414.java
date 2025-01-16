package BJ_0x15_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i = 0; i < L; i++){
            String tmp = br.readLine();

            if(!set.isEmpty() && set.contains(tmp)){
                set.remove(tmp);
            }

            set.add(tmp);
        }

        int cnt = 0;
        Iterator<String> iterSet = set.iterator();
        while(iterSet.hasNext()){
            if(cnt == K){
                break;
            }

            sb.append(iterSet.next()).append("\n");
            cnt++;
        }

        System.out.println(sb);
    }
}
