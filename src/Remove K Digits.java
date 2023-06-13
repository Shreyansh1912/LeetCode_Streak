class Solution {
    public String removeKdigits(String num, int k) {
        
        char[] nums = num.toCharArray();

        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0; i<n; i++){

            while(!st.isEmpty() && st.peek() > nums[i] && k-- >0)
               st.pop();

            if(st.isEmpty() && nums[i] == '0') continue;

            st.push(nums[i]);   
        }
        while(!st.isEmpty() && k-->0){
            st.pop();
        }
        if(st.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty())
          sb.append(st.pop());

        return sb.reverse().toString();  
    }
}
