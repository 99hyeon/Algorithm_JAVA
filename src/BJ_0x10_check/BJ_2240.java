//package BJ_0x10_check;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BJ_2240 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int T = Integer.parseInt(st.nextToken());
//        int W = Integer.parseInt(st.nextToken());
//
//        int[] apple = new int[T];
//        for(int i = 0; i < T; i++){
//            apple[i] = Integer.parseInt(br.readLine());
//        }
//
//        Queue<Jado> queue = new LinkedList<>();
//        int max = 0;
//        queue.add(new Jado(1, -1, 0, 0));
//        while(!queue.isEmpty()){
//            Jado poll = queue.poll();
//
//            if(poll.appleIdx + 1 >= T){
//                max = Math.max(poll.appleCnt, max);
//                continue;
//            }
//
//            if(poll.currentLoc == apple[poll.appleIdx + 1]){
//                queue.add(new Jado(poll.currentLoc, poll.appleIdx + 1, poll.appleCnt += 1, poll.moveCnt));
//            }else{
//                if(poll.moveCnt == W){
//                    max = Math.max(poll.appleCnt, max);
//                }else{
//                    queue.add(new Jado(poll.currentLoc, poll.appleIdx + 1, poll.appleCnt, poll.moveCnt));
//                    queue.add(new Jado(poll.currentLoc == 1 ? 2 : 1, poll.appleIdx + 1, poll.appleCnt += 1, poll.moveCnt + 1));
//                }
//            }
//        }
//
//        System.out.println(max);
//
//    }
//
//    static class Jado{
//        int currentLoc;
//        int appleIdx;
//        int appleCnt;
//        int moveCnt;
//
//        public Jado(int currentLoc, int appleIdx, int appleCnt, int moveCnt) {
//            this.currentLoc = currentLoc;
//            this.appleIdx = appleIdx;
//            this.appleCnt = appleCnt;
//            this.moveCnt = moveCnt;
//        }
//    }
//}
