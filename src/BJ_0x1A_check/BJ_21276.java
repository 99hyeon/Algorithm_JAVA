package BJ_0x1A_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<String> name = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            String tmpName = st.nextToken();
            name.add(tmpName);
        }
        Collections.sort(name);

        HashMap<Integer, String> findName = new HashMap<>();
        HashMap<String, Integer> findIdx = new HashMap<>();
        List<Person> person = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            findName.put(i, name.get(i));
            findIdx.put(name.get(i), i);
            person.add(new Person(name.get(i)));
            list.add(new ArrayList<>());
        }
        int[] edgeCnt = new int[N];

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String father = st.nextToken();

            edgeCnt[findIdx.get(child)] += 1;
            list.get(findIdx.get(father)).add(findIdx.get(child));
        }
        br.close();

        Queue<Integer> parent = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(edgeCnt[i] == 0){
                parent.add(i);
            }
        }

        sb.append(parent.size()).append("\n");
        for (Integer integer : parent) {
            sb.append(findName.get(integer)).append(" ");
        }
        sb.append("\n");

        while(!parent.isEmpty()){
            int poll = parent.poll();

            for(int i = 0; i < list.get(poll).size(); i++){
                int tmp = list.get(poll).get(i);
                if(--edgeCnt[tmp] == 0){
                    person.get(poll).child.add(findName.get(tmp));
                    parent.add(tmp);
                }
            }
        }

        for (Person one : person) {
            one.sort();

            if(one.child.size() == 0){
                sb.append(one.name).append(" ").append(0).append("\n");
            }else{
                sb.append(one.name).append(" ").append(one.child.size()).append(" ");
                for (String childName : one.child) {
                    sb.append(childName + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Person{
        String name;
        List<String> child;

        public Person(String name) {
            this.name = name;
            this.child = new ArrayList<>();
        }

        public void sort(){
            if(!child.isEmpty()) Collections.sort(child);
        }
    }
}

/**
 * 다시
 */