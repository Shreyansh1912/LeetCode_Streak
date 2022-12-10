class Solution {
    public int res = 0;
    public int maxProduct(TreeNode root) {
        int mod = (int)1e9+7;
        int sum = allSum(root);
        inorder(root,sum);
        
        int num1 = res;
        int num2 = sum - res;
        int ans = 0;
		// Calculate the product
        for(int i = 0; i < num1; i++){
            ans += num2;
            if(ans > mod){
                ans -= mod;
            }
        }
        
        return ans;
    }
    
    public int inorder(TreeNode root, int sum){
        int cur = 0;
        if(root == null){
            return 0;
        }
        cur += inorder(root.left,sum);
        cur += root.val;
        cur += inorder(root.right,sum);
        int minClose = Math.abs(res - sum/2);
        int curClose = Math.abs(cur - sum/2);
        res = curClose < minClose ? cur : res;
        
        return cur;
    }
    
    public int allSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + allSum(root.left) + allSum(root.right);
    }
}
