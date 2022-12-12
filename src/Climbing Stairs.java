class Solution {
    public int climbStairs(int n) {
       return totalWays(0, n, new HashMap<Integer, Integer>());
    }
    private int totalWays(int currentStair, int TargetStair, HashMap<Integer, Integer> memo){
        
        if(currentStair == TargetStair) return 1;
        
        if(currentStair > TargetStair) return 0;
        
        int currentKey = currentStair;        //TC:O(N), SC:O(N)
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int oneJump = totalWays(currentStair+1, TargetStair, memo);
        int twoJump = totalWays(currentStair+2, TargetStair, memo);
        
        memo.put(currentStair, oneJump + twoJump);
        
        return oneJump + twoJump;
    }
}
