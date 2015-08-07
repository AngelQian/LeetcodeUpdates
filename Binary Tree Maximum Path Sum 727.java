/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return result;
    }
    
    private int maxPathSumHelper(TreeNode root){
        if(root==null)
            return 0;
        
        int sum=root.val;
        int left = maxPathSumHelper(root.left);
        sum += Math.max(0,left);
        int right = maxPathSumHelper(root.right);
        sum += Math.max(0,right);
        
        result = Math.max(result, sum);
        
        return Math.max(left,right)>0 ? Math.max(left,right)+root.val : root.val;
    }
}