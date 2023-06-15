/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //TC: O(N), SC: O(N)
class Solution {
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int ans = 0;

        // var queue = new LinkedList<TreeNode>();
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        for(var level=1; !queue.isEmpty(); level++){
            var sum=0;

           for(var i=queue.size(); i>0; i--){
               var node = queue.poll();

               sum += node.val;
               if(node.left != null) queue.offer(node.left);
               if(node.right != null) queue.offer(node.right);
            } 
            if(sum > max){
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}
