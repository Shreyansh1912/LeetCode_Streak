class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        var uf = new UF(n);
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        for (var e : edgeList)
            uf.union(e[0], e[1], e[2]);
        
        var answer = new boolean[queries.length];
        for (var i = 0; i < queries.length; ++i)
            answer[i] = uf.connected(queries[i][0], queries[i][1], queries[i][2]);

        return answer;
    }
}

class UF {

    private final int[] id, rank, limits;

    UF(int N) {
        this.id = new int[N];
        this.rank = new int[N];
        this.limits = new int[N];

        for (var i = 0; i < N; ++i)
            id[i] = i;
    }

    void union(int p, int q, int limit) {
        var pId = find(p);
        var qId = find(q);

        if (pId == qId)
            return;

        if (rank[pId] < rank[qId]) {
            id[pId] = qId;
            limits[pId] = limit;
        } else if (rank[pId] > rank[qId]) {
            id[qId] = pId;
            limits[qId] = limit;
        } else {
            id[qId] = pId;
            limits[qId] = limit;
            rank[pId]++;
        }
    }

    boolean connected(int p, int q, int limit) {
        return find(p, limit) == find(q, limit);
    }

    private int find(int p) {
        while (p != id[p])
            p = id[p];
        
        return p;
    }

    private int find(int p, int limit) {
        while (p != id[p] && limits[p] < limit)
            p = id[p];
        
        return p;
    }
}
