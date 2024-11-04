//package BJ_0x0D_check;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//import javax.swing.DesktopManager;
//
//public class BJ_14889 {
//
//    static int N;
//    static int endMakeTeam;
//    static int teamCount;
//    static int[][] board;
//
//    static int[] teamStart;
//    static int[] teamLink;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//        board = new int[N][N];
//        teamStart = new int[N/2];
//        teamLink = new int[N/2];
//
//        StringTokenizer st;
//        for(int i = 0; i < N; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < N; j++){
//                board[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        endMakeTeam = calculateCombination();
//        separateTeam(0, 0);
//    }
//
//    static void separateTeam(int start,int depth){
//        if(depth == N/2){
//            teamCount += 1;
//
//            return;
//        }
//
//        for(int i = start; i < N; i++){
//            teamStart[depth] = i;
//            separateTeam(i+1, depth+1);
//            if(teamCount == endMakeTeam){
//                break;
//            }
//        }
//    }
//
//    static int calculateCombination(){
//        int combination = 0;
//        int halfN = N/2;
//
//        int numerator = 1;
//        for(int i = N; i > halfN; i--){
//            numerator *= i;
//        }
//
//        int denominator = 1;
//        for(int i = 1; i <= halfN; i++){
//            denominator *= i;
//        }
//
//        combination = numerator / (denominator * 2);
//
//        return combination;
//    }
//
//    static void compareTeam(int[] teamStart){
//        int startHP = 0;
//        int linkHP = 0;
//
//        for(int i = 0; i <)
//
//
//
//    }
//}
