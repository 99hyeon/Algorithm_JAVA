package BJ_0x15_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16165 {

    static HashMap<String, List<String>> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        hashMap = new HashMap<>();
        for(int i = 0; i < N; i++){
            String teamName = br.readLine();
            int num = Integer.parseInt(br.readLine());

            List<String> member = new ArrayList<>();
            for(int j = 0; j < num; j++){
                member.add(br.readLine());
            }

            hashMap.put(teamName, member);
        }

        for(int i = 0; i < M; i++){
            String teamOrMem = br.readLine();
            int number = Integer.parseInt(br.readLine());

            if(number == 0){
                List<String> tmp = findMember(teamOrMem);
                Collections.sort(tmp);

                for (String member : tmp) {
                    sb.append(member).append("\n");
                }
            }else{
                sb.append(findTeam(teamOrMem)).append("\n");
            }
        }

        System.out.println(sb);

    }

    static String findTeam(String member){
        for (String team : hashMap.keySet()) {
            if(hashMap.get(team).contains(member)){
                return team;
            }
        }
        return null;
    }

    static List<String> findMember(String team){
        return hashMap.get(team);
    }
}
