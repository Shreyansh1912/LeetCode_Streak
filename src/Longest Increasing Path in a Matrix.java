class Solution {
    private int[][] directions = {{1,0}, {-1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int longestPath = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int path = dfs(matrix, m , n, i , j, memo);
                longestPath = Math.max(path, longestPath);
            }
        }
        return longestPath;
    }
    public int dfs(int[][] matrix, int m , int n, int i, int j, int[][] memo){
        if(memo[i][j] > 0) return memo[i][j];
        
        int max = 0;

        for(int[] d: directions){
            int neighX = i + d[0];
            int neighY = j + d[1];

            if(neighX >= 0 && neighY >= 0 && neighX < m && neighY < n && matrix[neighX][neighY] > matrix[i][j]){
                max = Math.max(max, dfs(matrix, m, n, neighX, neighY, memo));
            }
        }
        memo[i][j] = max + 1;
        return max + 1;
    }
}
