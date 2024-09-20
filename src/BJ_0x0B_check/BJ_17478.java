package BJ_0x0B_check;

import java.util.Scanner;

public class BJ_17478 {
    static StringBuilder sb = new StringBuilder();
    static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        sb.append("\"재귀함수가 뭔가요?\"").append("\n");
        sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");

        recursion(1, "____");

        sb.append("라고 답변하였지.").append("\n");

        System.out.println(sb);
    }

    static void recursion(int order, String underbar){
        StringBuilder tmp = new StringBuilder(underbar);

        if(order != 1){
            tmp.append("____");
        }

        sb.append(tmp).append("\"재귀함수가 뭔가요?\"").append("\n");

        if(order != num){
            sb.append(tmp).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n").append(tmp).append(
                    "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n").append(tmp).append(
                    "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
            recursion(order + 1, tmp.toString());

        }else{
            sb.append(tmp).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
        }
        sb.append(tmp).append("라고 답변하였지.").append("\n");
    }
}
