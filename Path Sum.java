/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumHelper(root, sum, 0);    
    }
    private boolean hasPathSumHelper(TreeNode root, int sum, int value){
        if(root == null)
           return false;
        if(root.left == null && root.right == null)
            return sum == value+root.val;
        
        return hasPathSumHelper(root.left, sum, value+root.val) || hasPathSumHelper(root.right, sum, value+root.val);
    }
}