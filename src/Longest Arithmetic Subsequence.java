class Solution {
    public int longestArithSeqLength(int[] nums) {
      int len = nums.length;
      HashMap<Integer, Integer>[] dp = new HashMap[len];
      int maxValue = 1;
      
      for(int i=0; i<len; i++){
          int currElement = nums[i];
          dp[i] = new HashMap<>();
          HashMap<Integer, Integer> currentMap = dp[i];

          for(int j=0; j<i; j++){
              int diff = currElement - nums[j];
              HashMap<Integer, Integer> prevMap = dp[j];

              int newValue = prevMap.getOrDefault(diff, 0)+1;
              currentMap.put(diff, newValue);
              dp[i] = currentMap;
              maxValue = Math.max(maxValue, currentMap.get(diff));
          }
      }

      return (maxValue + 1);

    }
}
