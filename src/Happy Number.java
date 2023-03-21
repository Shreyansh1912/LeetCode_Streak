class Solution {
    public boolean isHappy(int n) {
        List<Integer> number = new ArrayList<>();
        while(n!=1){
            int temp=n;
            n=0;
            while(temp>0){
                n = n + (int) Math.pow((temp%10),2);
                temp=temp/10;
            }
            if(number.contains(n)) return false;
            else number.add(n);
        }
        return true;
    }
}
