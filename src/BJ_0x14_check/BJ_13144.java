//package BJ_0x14_check;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BJ_13144 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] array = new int[N];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++){
//            array[i] = Integer.parseInt(st.nextToken());
//        }
//
//        long cnt = 0;
//        for(int i = 0; i < N; i++){
//            int end = i;
//            int[] check = new int[100000 + 1];
//
//            while(end <= N){
//                if(end == N || check[array[end]] > 0){
//                    cnt += end - i;
//                    if(end < N){
//                        check[array[end]] = 0;
//                    }
//                    break;
//                }
//
//                check[array[end]] = 1;
//                end++;
//            }
//        }
//
//        System.out.println(cnt);
//    }
//}
