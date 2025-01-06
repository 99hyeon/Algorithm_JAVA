package BJ_0x11_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int multitabNum = Integer.parseInt(st.nextToken());
        List<Integer> multitab = new ArrayList<>();

        int num = Integer.parseInt(st.nextToken());
        List<Integer> machineOrder = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            int tmp = Integer.parseInt(st.nextToken());

            machineOrder.add(tmp);
        }

        boolean checkAll = false;
        for(int i = 0; i < multitabNum; i++){
            if(machineOrder.isEmpty()){
                checkAll = true;
                break;
            }

            int tmp = machineOrder.remove(0);

            if(!multitab.contains(tmp)){
                multitab.add(tmp);
            }else{
                i--;
            }
        }

        if(checkAll){
            System.out.println(0);
            System.exit(0);
        }

        int cnt = 0;
        while(!machineOrder.isEmpty()){
            int machineTmp = machineOrder.remove(0);

            if(!multitab.contains(machineTmp)){
                int maxIdx = -1;
                for(int i = 0; i < multitab.size(); i++){
                    int multitabMachine = multitab.get(i);

                    if(!machineOrder.contains(multitabMachine)){
                        cnt++;

                        multitab.remove(i);
                        multitab.add(machineTmp);
                        maxIdx = -1;
                        break;
                    }else{
                        maxIdx = Math.max(machineOrder.indexOf(multitabMachine), maxIdx);
                    }
                }

                if(maxIdx != -1){
                    multitab.remove(machineOrder.get(maxIdx));
                    multitab.add(machineTmp);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
