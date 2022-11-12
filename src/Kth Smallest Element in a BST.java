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
    int count =0; int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        smallest(root, k);
        return ans;
    }
    private void smallest(TreeNode root, int k){
        //Inorder Traversal
        if(root.left != null){
            smallest(root.left, k);
        }
        count++;
        if(count == k){
            ans = root.val;
            return;
        }
        if(root.right != null){
            smallest(root.right, k);
        }
    }
}
