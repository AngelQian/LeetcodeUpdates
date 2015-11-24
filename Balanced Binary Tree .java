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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)>=0;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(left==-1 || right==-1 || Math.abs(left-right)>1)
           return -1;
        
        return Math.max(left,right)+1;
    }
}

================================================
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
    public boolean isBalanced(TreeNode root) {
        // |left-right|<=1
        if(root==null)
            return true;
        
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)
            return false;
            
        return isBalanced(root.left) && isBalanced(root.right);    
            
    }
    
    private int height(TreeNode node){
        if(node==null)
            return 0;
        
        return 1+Math.max(height(node.left),height(node.right));
    }
}
