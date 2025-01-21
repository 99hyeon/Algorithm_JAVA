package BJ_0x18_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2606 {

    static List<List<Integer>> list;
    static HashSet<Integer> hashSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computerNum = Integer.parseInt(br.readLine());
        int networkNum = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i = 0; i <= computerNum; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < networkNum; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        hashSet = new HashSet<>();
        hashSet.add(1);
        dfs(1);
        System.out.println(hashSet.size() - 1);
    }

    static void dfs(int start){
        for(int i = 0; i < list.get(start).size(); i++){
            int tmp = list.get(start).get(i);

            if(!hashSet.contains(tmp)){
                hashSet.add(tmp);
                dfs(tmp);
            }
        }
    }
}

/**
 * 다른 코드 참고해보기
 */