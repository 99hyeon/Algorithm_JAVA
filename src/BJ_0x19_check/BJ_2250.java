package BJ_0x19_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class BJ_2250 {

    static int[] levelMin;
    static int[] levelMax;
    static List<Node> tree;
    static int xLoc = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        tree = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());

        levelMin = new int[N + 1];
        levelMax = new int[N + 1];
        for(int i = 0; i <= N; i++){
            tree.add(new Node(i, -1, -1));
            levelMin[i] = N;
            levelMax[i] = 0;
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree.get(idx).left = left;
            tree.get(idx).right = right;

            if(left != -1){
                tree.get(left).parent = idx;
            }
            if(right != -1 ){
                tree.get(right).parent = idx;
            }
        }

        int rootIdx = 0;
        for(int i = 1; i <= N; i++){
            if(tree.get(i).parent == -1){
                rootIdx = i;
                break;
            }
        }

        inOrder(rootIdx, 1);
        int maxLevel = 0;
        int maxWidth = 0;
        for(int i = 1; i <= N; i++){
            int tmp = levelMax[i] - levelMin[i] + 1;
            if(maxWidth < tmp){
                maxWidth = tmp;
                maxLevel = i;
            }
        }

        System.out.println(maxLevel + "\n" + maxWidth);


    }

    static void inOrder(int idx, int level){
        if(tree.get(idx).left == -1){
            levelMin[level] = Math.min(levelMin[level], xLoc);
            levelMax[level] = Math.max(levelMax[level], xLoc);
            xLoc++;

            if(tree.get(idx).right != -1){
                inOrder(tree.get(idx).right, level + 1);
            }
            return;
        }else{
            inOrder(tree.get(idx).left, level + 1);
        }

        levelMin[level] = Math.min(levelMin[level], xLoc);
        levelMax[level] = Math.max(levelMax[level], xLoc);
        xLoc++;

        if(tree.get(idx).right != -1){
            inOrder(tree.get(idx).right, level + 1);
        }
    }

    static class Node{
        int parent;
        int idx;
        int left;
        int right;

        public Node(int idx, int left, int right) {
            this.parent = -1;
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * 다시
 */