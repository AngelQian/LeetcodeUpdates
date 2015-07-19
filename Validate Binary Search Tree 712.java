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
        return isValidBSTHelper(root, null, null);
    }
    
    private boolean isValidBSTHelper(TreeNode root, Integer minValue, Integer maxValue){
        if(root == null)
            return true;
            
        boolean v = true;
        if(minValue!=null)
         v &= root.val>minValue;
        if(maxValue!=null)
         v &= root.val<maxValue;
         
        return v
            && isValidBSTHelper(root.left, minValue, root.val)
            && isValidBSTHelper(root.right, root.val, maxValue);
    }
}