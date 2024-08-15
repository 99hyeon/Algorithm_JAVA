package BJ_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        br.close();

        StringBuilder sb = new StringBuilder();

        if(A == B){
            sb.append(B-A).append("\n");
        } else if(A > B){
            sb.append(A - B - 1).append("\n");

            for(long i = B+1; i < A; i++){
                sb.append(i).append(" ");
            }

        } else{
            sb.append(B - A - 1).append("\n");

            for(long i = A+1; i < B; i++){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}

/**
 * 정말 많이 틀린 문제
 *
 * 내가 놓친 부분
 * 1. A와 B가 같을 경우
 * 2. A가 B보다 클 경우
 * 위 두 부분을 생각하지 못해서 계속 틀렸다
 *
 * 그리고 서브태스크 때문에
 * 3. int형이 아닌 long 타입을 사용해야 함
 * 따라서 Integer.parseInt가 아닌 Long.parseLong을 사용해야 한다.
 *
 * 문제에 A < B라는 조건이 없는데 자연스럽게 그렇게 생각을 함.
 * 기준을 꼼꼼하게 일자
 */