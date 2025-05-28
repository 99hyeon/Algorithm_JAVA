package BJ_0x04_clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        LinkedList<Character> pw;
        for(int i = 0; i < num; i++){
            String tmpPw = br.readLine();

            pw = new LinkedList<>();
            int index = 0;
            for(int j = 0; j < tmpPw.length(); j++){
                char tmp = tmpPw.charAt(j);

                switch (tmp){
                    case '>':
                        if(index == pw.size()){
                            break;
                        }else{
                            index++;
                            break;
                        }
                    case '<':
                        if(index == 0){
                            break;
                        }else{
                            index--;
                            break;
                        }
                    case '-':
                        if(index == 0){
                            break;
                        }else{
                            pw.remove(--index);
                            break;
                        }
                    default:
                        pw.add(index, tmp);
                        index++;
                        break;
                }

            }

            for (Character character : pw) {
                sb.append(character);
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }
}
