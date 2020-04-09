package UnionFInd;

/**
 * leetcode 1202 medium
 */

import java.util.*;
public class SmallestStringWithSwaps {
    int[] parent;
    int[] level;

    public String Main(String s, List<List<Integer>> pairs){
        char[] cs = s.toCharArray();
        parent = new int[cs.length];
        level = new int[cs.length];
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i=0;i<parent.length;i++)
            parent[i] = i;
        for(List<Integer> pair : pairs)
            union(pair.get(0), pair.get(1));
        for(int i=0;i<cs.length;i++){
            int p = find(i);//对每个点找到root
            PriorityQueue<Character> pq = map.getOrDefault(p, new PriorityQueue<Character>());
            pq.offer(cs[i]);
            map.putIfAbsent(p, pq);

        }
        for(int i=0;i<cs.length;i++)
            cs[i] = map.get(find(i)).poll();
        return new String(cs);

    }

    private void union(int a, int b){//进行连通
        int pa = find(a);
        int pb = find(b);//找到两者的father
        if(pa!=pb){//不是同一个连通块，需要重连
            if(level[pa]>level[pb]){
                parent[pb] = pa;
            }else if(level[pa]<level[pb]){
                parent[pa] = pb;
            }else{
                parent[pb] = pa;
                level[pa]++;
            }

        }

    }

    private int find(int a){//找到该连通块的
        if(parent[a]==a)
            return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }
}
