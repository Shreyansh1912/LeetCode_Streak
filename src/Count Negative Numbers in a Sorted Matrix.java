//Brute Force
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] < 0) c++;
            }
        }
        return c;
    }
}
//Binary Search
class Solution {
    public int countNegatives(int[][] grid) {
        int c=0;
        for(int[] row: grid){
            int l=0, r=grid[0].length-1;

            while(l <= r){
                int mid = (l+r)/2;
                if(row[mid] < 0) {
                    r = mid-1;
                } else{
                    l = mid+1;
                }
            }
           c += ((grid[0].length)-l);
        }
        return c;
    }
}
