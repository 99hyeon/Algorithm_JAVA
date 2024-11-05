package BJ_0x0D_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14889 {

    static int N;
    static long endMakeTeam;
    static long teamCount;
    static int[][] board;
    static int min = Integer.MAX_VALUE;

    static int[] teamStart;
    static int[] teamLink;

    static int teamStartSum;
    static int teamLinkSum;

    static int[] forStartTeamSum;
    static int[] forLinkTeamSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        teamStart = new int[N/2];
        teamLink = new int[N/2];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        endMakeTeam = calculateCombination();
        separateTeam(0, 0);
        System.out.println(min);
    }

    static void separateTeam(int start,int depth){
        if(depth == N/2){
            teamCount += 1;

            int idx = 0;
            for(int i = 0; i < N; i++){
                int num = i;
                if(Arrays.stream(teamStart).noneMatch(x -> x == num)){
                    teamLink[idx] = i;
                    idx++;
                }
            }
            compareTeam();
            return;
        }

        for(int i = start; i < N; i++){
            teamStart[depth] = i;
            separateTeam(i+1, depth+1);
            if(teamCount == endMakeTeam){
                break;
            }
        }
    }

    static long calculateCombination(){
        long combination = 0;
        long halfN = N/2;

        long numerator = 1;
        for(int i = N; i > halfN; i--){
            numerator *= i;
        }

        long denominator = 1;
        for(int i = 1; i <= halfN; i++){
            denominator *= i;
        }

        combination = numerator / (denominator * 2);

        return combination;
    }

    static void addTeamWeight(int start, int depth, boolean isTeamStart){
        if(depth == 2){
            if(isTeamStart){
                teamStartSum = teamStartSum + board[forStartTeamSum[0]][forStartTeamSum[1]] + board[forStartTeamSum[1]][forStartTeamSum[0]];
            }else{
                teamLinkSum = teamLinkSum + board[forLinkTeamSum[0]][forLinkTeamSum[1]] + board[forLinkTeamSum[1]][forLinkTeamSum[0]];
            }
            return;
        }

        for(int i = start; i < N/2; i++){
            if(isTeamStart){
                forStartTeamSum[depth] = teamStart[i];
            }else{
                forLinkTeamSum[depth] = teamLink[i];
            }
            addTeamWeight(i+1, depth +1, isTeamStart);
        }
    }

    static void compareTeam(){
        forStartTeamSum = new int[2];
        forLinkTeamSum = new int[2];

        teamStartSum = 0;
        teamLinkSum = 0;

        addTeamWeight(0, 0, true);
        addTeamWeight(0, 0, false);

        min = Math.min(min, Math.abs(teamStartSum - teamLinkSum));
    }
}
