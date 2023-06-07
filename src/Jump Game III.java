// class Solution {
//      boolean[] vis;
//     public boolean canReach(int[] arr, int start) {
//         vis = new boolean[arr.length];
//         return dfs(arr, start);
//     }
//     public boolean dfs(int[] arr, int curr){
//         if(curr<0 || curr>=arr.length || vis[curr]) return false;

//         if(arr[curr] == 0) return true;

//         vis[curr] = true;

//         return dfs(arr, curr+arr[curr]) || dfs(arr, curr-arr[curr]);   
//     }
// }
class Solution {
    public boolean canReach(int[] arr, int start) {
         int n = arr.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                if(vis[curr])
                    continue;
                if(arr[curr] == 0)
                    return true;
                if(curr+arr[curr] < n)
                    q.add(curr+arr[curr]);
                if(curr-arr[curr] >= 0)
                    q.add(curr-arr[curr]);
                vis[curr] = true;
            }
        }
        return false;
    }
}
