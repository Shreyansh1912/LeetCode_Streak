class Solution {
    public int largestAltitude(int[] gain) {
        int currentAlt = 0;
        int max = currentAlt;

        for(int altGain: gain){
            currentAlt += altGain;
      
          max = Math.max(max, currentAlt);  
        }
       return max; 
    }
}
