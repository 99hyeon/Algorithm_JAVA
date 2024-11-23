package BJ_0x0F_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_81731 {

    static BufferedReader br;
    static ArrayList<Integer> A;
    static ArrayList<Integer> B;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < testNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = new ArrayList<>();
            B = new ArrayList<>();

            int Asize = Integer.parseInt(st.nextToken());
            int Bsize = Integer.parseInt(st.nextToken());
            put(Asize, true);
            put(Bsize, false);

            sb.append(check()).append("\n");
        }

        System.out.println(sb);
    }

    static void put(int size, boolean isA) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++){
            if(isA){
                A.add(Integer.parseInt(st.nextToken()));
            }else{
                B.add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static int check(){
        int count = 0;

        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        for (Integer Anum : A) {
            for(int i = 0; i < B.size(); i++){
                if(Anum > B.get(i)){
                    count += B.size() - i;
                    break;
                }
            }
        }

        return count;
    }


}
