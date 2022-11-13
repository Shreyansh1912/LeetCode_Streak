class Solution {
    public String reverseWords(String s) {
     String[] words = s.trim().split(" +");  //The plus sign + is a greedy quantifier, which means one or more times space
     Collections.reverse(Arrays.asList(words));
     return String.join(" ",words); 
    }
}
