class Solution {
    private class Pair{
        int val1;
        int val2;

        public Pair(int val1, int val2){
            this.val1 = val1;
            this.val2 = val2;
        }
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] nums = new Pair[n];
        for(int i=0; i<n; i++){
            nums[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(nums, (a,b)->{
            if(a.val2 == b.val2){
                return a.val1 - b.val1;
            }
            return a.val2 - b.val2;
        });
        long sum = 0;
        long ans = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=n-1; i>=0; --i){
            int minVal = nums[i].val2;
            while(pq.size() > k-1){
                 sum -= pq.poll();
            }
            sum += nums[i].val1;
            pq.add(nums[i].val1);
            if(pq.size() == k){
                ans = Math.max(ans, sum*minVal);
            }
        }
        return ans;
    }
}
