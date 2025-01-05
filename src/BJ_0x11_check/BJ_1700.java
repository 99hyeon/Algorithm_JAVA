//package BJ_0x11_check;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class BJ_1700 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int multitabNum = Integer.parseInt(st.nextToken());
//        int[] multitab = new int[multitabNum];
//
//        int num = Integer.parseInt(st.nextToken());
//        int[] machine = new int[101];
//        List<Integer> machineOrder = new ArrayList<>();
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < num; i++){
//            int tmp = Integer.parseInt(st.nextToken());
//
//            machineOrder.add(tmp);
//            machine[tmp] += 1;
//        }
//
//        int usingTabNum = 0;
//        int count = 0;
//        while(!machineOrder.isEmpty()){
//            boolean checkTab = false;
//            int currentMachineNum = machineOrder.removeFirst();
//            for(int j = 0; j < usingTabNum; j++){
//                if(multitab[j] == currentMachineNum){
//                    checkTab = true;
//                }
//            }
//
//            if(!checkTab){
//                if(usingTabNum < multitabNum){
//                    multitab[usingTabNum] = currentMachineNum;
//                    machine[currentMachineNum] -= 1;
//                    usingTabNum++;
//                }else{
//                    boolean checkUsingAllLater = true;
//                    int laterIdx = -1;
//                    for(int j = 0; j < multitabNum; j++){
//                        if(machine[multitab[j]] == 0){
//                            checkUsingAllLater = false;
//                            count += 1;
//                            multitab[j] = currentMachineNum;
//                            machine[currentMachineNum] -= 1;
//                            break;
//                        }else{
//                            laterIdx = Math.max(laterIdx, machineOrder.indexOf(currentMachineNum));
//                        }
//                    }
//
//                    if(checkUsingAllLater){
//
//                    }
//                }
//            }else{
//                machine[currentMachineNum] -= 1;
//            }
//        }
//
//        System.out.println(count);
//
//    }
//}
