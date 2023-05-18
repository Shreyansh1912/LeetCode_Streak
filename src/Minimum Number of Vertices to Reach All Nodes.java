class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer>[] g = new ArrayList[n];

        for(int i=0; i<n; i++){
            g[i] = new ArrayList();
        }

        int[] inDegree = new int[n];
        for(List<Integer> e: edges){
            g[e.get(0)].add(e.get(1));
            inDegree[e.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0)
               res.add(i);
        }
        return res;
    }
}
