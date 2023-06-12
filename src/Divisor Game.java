// class Solution {
//     public boolean divisorGame(int n) {
//         return n%2==0;
//     }
// }

class Solution {
    public boolean divisorGame(int n) {

        if(n < 1) return false;

        for(int i=1; i<n; i++){
            if(n % i == 0)
               return !divisorGame(n-i);
        }
        return false;
    }
}
