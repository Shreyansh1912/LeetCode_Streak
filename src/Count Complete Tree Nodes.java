 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int left = getHeightLeft(root);
        int right = getHeightRight(root);
        
        if(left == right) return ((2<<(left))-1);
        
       else  
           return countNodes(root.left)+countNodes(root.right)+1; 
    }
    public int getHeightLeft(TreeNode root){
        int c=0;
        while(root.left != null){
            c++;
            root = root.left;
        }
        return c;
    }
    public int getHeightRight(TreeNode root){
        int c=0;
        while(root.right != null){
            c++;
            root = root.right;
        }
        return c;
    }
}
