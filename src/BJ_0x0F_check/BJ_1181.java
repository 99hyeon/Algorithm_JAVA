package BJ_0x0F_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < num; i++){
            arrayList.add(br.readLine());
        }

        Collections.sort(arrayList);

        int front = 0;
        int back = 1;
        while(front < arrayList.size() - 1){
            if(arrayList.get(front).length() > arrayList.get(back).length()){
                for(int i = 0; i <= front; i++){
                    if(arrayList.get(i).length() > arrayList.get(back).length()){
                        arrayList.add(i, arrayList.remove(back));
                        break;
                    }
                }
            }
            front += 1;
            back += 1;
        }

        sb.append(arrayList.get(0)).append("\n");
        for(int i = 1; i < arrayList.size(); i++){
            if(arrayList.get(i).equals(arrayList.get(i - 1))){
                continue;
            }
            sb.append(arrayList.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
