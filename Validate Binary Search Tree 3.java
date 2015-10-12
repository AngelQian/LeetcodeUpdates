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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTHelper(TreeNode node, long left, long right){
        if(node==null)
            return true; 
            
        if(node.val<=left || node.val>=right)
            return false;
        
        return  isValidBSTHelper(node.left, left, node.val)
                && isValidBSTHelper(node.right, node.val, right);
    }
}