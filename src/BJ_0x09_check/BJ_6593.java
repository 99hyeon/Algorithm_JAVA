package BJ_0x09_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593 {

    static char[][][] building;
    static int L;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        while(L != 0 && R != 0 && C != 0){
            building = new char[L][R][C];

            int startX = 0;
            int startY = 0;
            int startZ = 0;
            int endX = 0;
            int endY = 0;
            int endZ = 0;
            for(int k = 0; k < L; k++){
                for(int i = 0; i < R; i++){
                    String floor = br.readLine();
                    for(int j = 0; j < C; j++){
                        building[k][i][j] = floor.charAt(j);
                        if(building[k][i][j] == 'S'){
                            startZ = k;
                            startX = i;
                            startY = j;
                        }else if(building[k][i][j] == 'E'){
                            endZ = k;
                            endX = i;
                            endY = j;
                        }
                    }
                }
                br.readLine();
            }

            int minute = bfs(startX, startY, startZ, endX, endY, endZ);
            if(minute == -1){
                sb.append("Trapped!\n");
            }else{
                sb.append("Escaped in ").append(minute).append(" minute(s).\n");
            }

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }

    static int bfs(int x, int y, int z, int endX, int endY, int endZ){
        int[] dz = {-1, 1, 0, 0, 0, 0};
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, 0, -1, 1};

        boolean[][][] visited = new boolean[L][R][C];
        Queue<int[]> queue = new LinkedList<>();
        visited[z][x][y] = true;
        queue.add(new int[]{z, x, y, 0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int currentZ = poll[0];
            int currentX = poll[1];
            int currentY = poll[2];
            int currentMin = poll[3];

            for(int i = 0; i < 6; i++){
                int nextZ = currentZ + dz[i];
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextZ < 0 || nextZ >= L || nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
                    continue;
                if(building[nextZ][nextX][nextY] == '#' || visited[nextZ][nextX][nextY])
                    continue;

                if(nextZ == endZ && nextX == endX && nextY == endY){
                    return currentMin + 1;
                }

                visited[nextZ][nextX][nextY] = true;
                queue.add(new int[] {nextZ, nextX, nextY, currentMin + 1});
            }
        }

        return -1;
    }

}
