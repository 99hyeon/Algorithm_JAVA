package BJ_0x05_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_3015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<long[]> stack = new Stack<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            long height = Long.parseLong(br.readLine());
            long count = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                long[] top = stack.pop();
                answer += top[1];

                if (top[0] == height) {
                    count += top[1];
                }
            }

            if (!stack.isEmpty()) {
                answer++; // 현재 사람보다 큰 키가 남아있다면 볼 수 있음
            }

            stack.push(new long[]{height, count});
        }

        System.out.println(answer);
    }

}

/**
 * 다시
 */