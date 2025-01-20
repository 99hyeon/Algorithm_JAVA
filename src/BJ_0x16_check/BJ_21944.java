package BJ_0x16_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_21944 {
    static class Problem implements Comparable<Problem> {
        int number;
        int level;
        int algo;

        public Problem(int number, int level, int algo) {
            this.number = number;
            this.level = level;
            this.algo = algo;
        }

        @Override
        public int compareTo(Problem o) {
            if(level == o.level){
                return number - o.number;
            }else{
                return level - o.level;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        TreeSet<Problem> allProblems = new TreeSet<>();
        Map<Integer, TreeSet<Problem>> hashMap = new HashMap<>();
        Map<Integer, Integer> levelMap = new HashMap<>();
        Map<Integer, Integer> algoMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int algo = Integer.parseInt(st.nextToken());

            allProblems.add(new Problem(number, level, algo));
            if (hashMap.containsKey(algo)) {
                TreeSet<Problem> tmpTree = hashMap.get(algo);
                tmpTree.add(new Problem(number, level, algo));
                hashMap.replace(algo, tmpTree);
            } else {
                TreeSet<Problem> tmpTree = new TreeSet<>();
                tmpTree.add(new Problem(number, level, algo));
                hashMap.put(algo, tmpTree);
            }

            levelMap.put(number, level);
            algoMap.put(number, algo);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 1) {
                    sb.append(hashMap.get(G).last().number).append("\n");
                } else {
                    sb.append(hashMap.get(G).first().number).append("\n");
                }

            } else if (command.equals("recommend2")) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 1) {
                    sb.append(allProblems.last().number).append("\n");
                } else {
                    sb.append(allProblems.first().number).append("\n");
                }
            } else if (command.equals("recommend3")) {
                int tmp = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                if (tmp == 1) {
                    Problem tmpProblem = allProblems.ceiling(new Problem(Integer.MIN_VALUE, L, 0));
                    if (tmpProblem == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(tmpProblem.number).append("\n");
                    }
                } else {
                    Problem tmpProblem = allProblems.floor(new Problem(0, L, 0));
                    if (tmpProblem == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(tmpProblem.number).append("\n");
                    }
                }
            } else if (command.equals("add")) {
                int numberInput = Integer.parseInt(st.nextToken());
                int levelInput = Integer.parseInt(st.nextToken());
                int algoInput = Integer.parseInt(st.nextToken());

                allProblems.add(new Problem(numberInput, levelInput, algoInput));
                if (hashMap.containsKey(algoInput)) {
                    TreeSet<Problem> tmpTree = hashMap.get(algoInput);
                    tmpTree.add(new Problem(numberInput, levelInput, algoInput));
                    hashMap.replace(algoInput, tmpTree);
                } else {
                    TreeSet<Problem> treeSet = new TreeSet<>();
                    treeSet.add(new Problem(numberInput, levelInput, algoInput));
                    hashMap.put(algoInput, treeSet);
                }

                levelMap.put(numberInput, levelInput);
                algoMap.put(numberInput, algoInput);
            } else {
                int solve = Integer.parseInt(st.nextToken());
                int levelInput = levelMap.get(solve);
                int algoInput = algoMap.get(solve);

                allProblems.remove(new Problem(solve, levelInput, algoInput));
                hashMap.get(algoInput).remove(new Problem(solve, levelInput, algoInput));
                levelMap.remove(solve);
                algoMap.remove(solve);
            }
        }

        System.out.println(sb);
    }
}

/**
 * 참고 : https://velog.io/@courage331/%EB%B0%B1%EC%A4%80Java-21944-%EB%AC%B8%EC%A0%9C-%EC%B6%94%EC%B2%9C-%EC%8B%9C%EC%8A%A4%ED%85%9C-Version-2
 *
 * 왜 틀려??
 */