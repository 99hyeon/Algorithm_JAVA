package BJ_0x16_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BJ_1539 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        int[] depth = new int[250001];
        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i = 0; i < N; i++){
            int node = Integer.parseInt(br.readLine());

            if(treeSet.lower(node) == null){
                if(treeSet.higher(node) == null){
                    depth[node] = 1;
                }else{
                    depth[node] = depth[treeSet.higher(node)] + 1;
                }
            }else{
                if(treeSet.higher(node) == null){
                    depth[node] = depth[treeSet.lower(node)] + 1;
                }else{
                    depth[node] = Math.max(depth[treeSet.higher(node)], depth[treeSet.lower(node)]) + 1;
                }
            }
            treeSet.add(node);
            sum += depth[node];
        }

        System.out.println(sum);

    }

}
