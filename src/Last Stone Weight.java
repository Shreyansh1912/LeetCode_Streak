class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> al = new ArrayList<>();
 
        for(int x: stones)
            al.add(x);
        
        while(true){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int len = al.size();

            if(len == 1 || len == 0)
                 break;

            Collections.sort(al);
            min = al.get(len-2);
            max = al.get(len-1);

            if(min < max){
                max = max - min;
                al.remove(al.size()-1);
                al.remove(al.size()-1);
                al.add(max);
            }else if(min == max){
                al.remove(al.size()-1);
                al.remove(al.size()-1);
            }

        }
        if(al.size() == 1){
            return al.get(0);
        }
       return 0;
    }
}
