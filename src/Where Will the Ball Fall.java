class Solution {
    public int[] findBall(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      
     int[] ans = new int[m];
        
     for(int b=0; b<m; b++){
         int cpos = b;
         int npos = -1;
         
         for(int i=0; i<n; i++){
             npos = cpos+grid[i][cpos];
             
             if(npos < 0 || npos >= m || grid[i][cpos] != grid[i][npos]){
                 cpos=-1;
                 break;
             }
             cpos = npos;
         }
         ans[b] = cpos;
     }
    return ans;
    }
}
