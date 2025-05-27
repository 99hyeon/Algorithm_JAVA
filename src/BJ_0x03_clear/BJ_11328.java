package BJ_0x03_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String front = st.nextToken();
            String back = st.nextToken();

            if(front.length() != back.length()){
                sb.append("Impossible").append("\n");
            } else if(compare(front, back)){
                sb.append("Possible").append("\n");
            }else{
                sb.append("Impossible").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean compare(String front, String back){
        int[] checkVisit = new int[front.length()];

        for(int i = 0; i < back.length(); i++){
            boolean checkExist = false;
            for(int j = 0; j < front.length(); j++){
                if(back.charAt(i) == front.charAt(j)){
                    if(checkVisit[j] == 0){
                        checkVisit[j]++;
                        checkExist = true;
                        break;
                    }
                }
            }
            if(!checkExist){
                return false;
            }
        }

        for (int i : checkVisit) {
            if(i == 0){
                return false;
            }
        }
        return true;
    }
}
