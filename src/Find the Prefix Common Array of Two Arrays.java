class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int res[] = new int[A.length];
        
        for(int i = 0; i<A.length; i++){
            int temp = 0;
            if(set.contains(A[i])){
                temp++;
            }
            if(set.contains(B[i])){
                temp++;
            }
            if(A[i] == B[i]){
                temp++;
            }
            res[i] += temp;
            if(i > 0) res[i]+= res[i-1];
            set.add(A[i]);
            set.add(B[i]);
        }
        return res;
    }
}
