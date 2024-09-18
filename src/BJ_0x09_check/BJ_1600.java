package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600 {
    static int k;
    static int w;
    static int h;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[h][w];

        for(int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y){
        int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] hy = {-2, -1, 1, 2, -2, -1, 1, 2};

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][][] check = new boolean[h][w][k+1];
        check[x][y][0] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, 0));
        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(current.x == h-1 && current.y == w-1){
                return current.distance;
            }

            for(int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= h || nextY >= w || check[nextX][nextY][current.chance])
                    continue;
                if(board[nextX][nextY] != 1){
                    check[nextX][nextY][current.chance] = true;
                    queue.add(new Node (nextX, nextY, current.chance, current.distance+1));
                }
            }

            if(current.chance < k){
                for(int i = 0; i < 8; i++){
                    int nextX = current.x + hx[i];
                    int nextY = current.y + hy[i];

                    if(nextX < 0 || nextY < 0 || nextX >= h || nextY >= w || check[nextX][nextY][current.chance])
                        continue;
                    if(board[nextX][nextY] != 1){
                        check[nextX][nextY][current.chance+1] = true;
                        queue.add(new Node(nextX, nextY, current.chance+1, current.distance+1));
                    }
                }
            }
        }

        return -1;
    }

    static class Node{
        int x, y, chance, distance;

        public Node(int x, int y, int chance, int distance){
            this.x = x;
            this.y = y;
            this.chance = chance;
            this.distance = distance;
        }
    }

}

/**
 * 응~ 메모리 초과
 * 다른 사람 코드 보니 걍 거의 똑같더만 도대체 어디가 메모리 초과~?
 * 연휴라 머리가 도저히 안 돌아감
 * 이건 다음번에 다시 풀 때 재도전이다~
 * 에라이~
 * 이거랑 나중에 비교해보기 왜 메모리 초과인지~
 * https://loosie.tistory.com/378
 */
