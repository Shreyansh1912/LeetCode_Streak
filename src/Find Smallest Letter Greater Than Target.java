              /*         BRUTE FORCE APPROACH        */
// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         for(char c: letters){
//             if((c-'0') > (target-'0')){
//                 return c;
//             }
//         }
//         return letters[0];
//     }
// }

/*                 BINARY SEARCH  APPROACH                    */

class Solution {
   public char nextGreatestLetter(char[] letters, char target) {
       int low = 0;
       int high = letters.length-1;

       while(low <= high){
           int mid = (low + high)/2;

           if(letters[mid] <= target){
               low = mid+1;
           } else{
               high = mid-1;
           }
        }
       return low == letters.length ? letters[0] : letters[low];
   }
}
