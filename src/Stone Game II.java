class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefixSum = new int[n + 1];
        int[][] memo = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }
        return dfs(piles, prefixSum, 0, 1, memo);
    }

    private int dfs(int[] piles, int[] prefixSum, int i, int M, int[][] memo) {
        if (i == piles.length) {
            return 0;
        }
        if (2 * M >= piles.length - i) {
            return prefixSum[piles.length] - prefixSum[i];
        }
        if (memo[i][M] != 0) {
            return memo[i][M];
        }
        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++) {
            int stonesTaken = prefixSum[i + x] - prefixSum[i];
            int opponentStones = dfs(piles, prefixSum, i + x, Math.max(M, x), memo);
            int aliceStones = stonesTaken + (prefixSum[piles.length] - prefixSum[i + x]) - opponentStones;
            maxStones = Math.max(maxStones, aliceStones);
        }
        memo[i][M] = maxStones;
        return maxStones;
    }
}
