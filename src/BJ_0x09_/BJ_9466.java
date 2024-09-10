package BJ_0x09_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9466 {

    static int[] team;
    static int count;
    static boolean[] visit;
    static boolean[] done;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testNum; i++){
            int studentNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            team = new int[studentNum + 1];
            done = new boolean[studentNum + 1];
            visit = new boolean[studentNum + 1];
            count = 0;  //팀이 완성된 학생 수
            for(int j = 1; j <= studentNum; j++){
                team[j] = Integer.parseInt(st.nextToken());

                if(team[j] == j){
                    done[j] = true;
                    count++;
                }
            }

            for(int j = 1; j <= studentNum; j++){
                if(!done[j]){
                    dfs(j);
                }
            }
            sb.append(studentNum - count).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int current){

        if(visit[current]){
            done[current] = true;
            count++;
        }else{
            visit[current] = true;
        }

        if(!done[team[current]]){
            dfs(team[current]);
        }

        visit[current] = false;
        done[current] = true;
    }
}

/**
 * 다시 풀기
 */