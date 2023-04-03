class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Arrays.sort(people); TC: O(NlogN), SC: O(1) 
        //To optimized to TC:O(N) , SC:O(limit) --> use counting sort
        
        int[] count = new int[limit+1];
        for(int p:people){
            count[p]++;
        }
        int index=0;
        for(int val=1; val<=limit; val++){
            while(count[val] --> 0){
                people[index++] = val;
            }
        }
        int start=0, end = people.length-1;
        int boatCount=0;

        while(start <= end){
            if(people[start]+people[end] <= limit){
                start++;
                end--;
            }
            else{
                end--;
            }
             boatCount++;
        }
        return boatCount;
    }
}
