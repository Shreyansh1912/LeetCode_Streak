class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        findAllCombs(0, 0, "", answer, n);
        return answer;
    }
    private void findAllCombs(int open, int close, String exp,  List<String> answer, int n){
        if(open == close && open == n){
            answer.add(exp);
            return;
        }
        if(open < n){
            findAllCombs(open+1, close, exp+"(", answer, n);
        }
        if(close < open){
            findAllCombs(open, close+1, exp+")", answer, n);
        }
        return;
    }
}
