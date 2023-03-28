class Solution {
    List<Integer> res;
    int[] arr;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        arr = new int[nums.length];
        Arrays.fill(arr, -1);
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), 1);
        return res;
    }
    private void helper(int[] nums, int index, List<Integer> curr, int prev){
        if(curr.size() > res.size()){
            res = new ArrayList<>(curr);
        }
        for(int i=index; i<nums.length; i++){
          if(curr.size() > arr[i] && nums[i] % prev == 0){
              arr[i] = curr.size();
              curr.add(nums[i]);
              helper(nums, i+1, curr, nums[i]);
              curr.remove(curr.size()-1);
          }
        }
    }
}
